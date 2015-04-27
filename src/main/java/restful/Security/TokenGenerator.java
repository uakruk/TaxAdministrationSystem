package restful.Security;

import dao.Factory;
import logic.Taxpayer;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.resources.TaxpayerRes;
import org.apache.commons.codec.binary.Base64;

import java.sql.Date;
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
public abstract class TokenGenerator {

    public static String generate(String inputData) {
        Taxpayer tp;
        String resp;
        try {
            tp = Factory.getInstance().getTaxpayerDAO().getTaxpayerById(Long.parseLong(inputData));
            StringBuilder temp = new StringBuilder();
            temp.append(tp.getFullName());
            temp.append(tp.getTaxpayer_id().toString());
            temp.append(new Date(System.currentTimeMillis()).toString());
            String t = new String(temp);
            resp = Base64.encodeBase64String(t.getBytes());
            PermissionCheck.addToken(resp, tp.getRights());
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
        return resp;
    }
}
