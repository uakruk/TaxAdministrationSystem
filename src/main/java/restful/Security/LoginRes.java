package restful.Security;

import dao.Factory;
import logic.Taxpayer;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.AuthCheck;
import restful.Security.TokenGenerator;
import restful.Security.WrongLoginPasswordException;

import java.sql.SQLException;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 17.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public abstract class LoginRes {

    public static boolean check(String name, int pass) throws WrongLoginPasswordException {

        boolean res = false;
        Taxpayer tp;
        try {
            tp = Factory.getInstance().getTaxpayerDAO().getTaxpayerById(Long.parseLong(name));
            if (Integer.parseInt(tp.getPassword()) == pass) {
                res = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (res) {
            AuthCheck.addToken(TokenGenerator.generate(name));
        } else {
            throw new WrongLoginPasswordException();
        }
        return true;
    }

    public static boolean logOut(String token) {
        return AuthCheck.removeToken(token);
    }
}
