package restful.resources;

import dao.Factory;
import logic.Contact;
import logic.Taxpayer;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.AttemptionToRepeatRegistration;

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
public class Registrator {

    public static boolean register(JSONObject src) throws AttemptionToRepeatRegistration {
        try {
            long taxpayer_id = src.optLong("taxpayer_id");
            String password = new Integer(src.optString("password").hashCode()).toString();
            String rights = "user";
            String email = src.optString("email");
            Taxpayer tp = Factory.getInstance().getTaxpayerDAO().getTaxpayerById(taxpayer_id);
            Contact c = new Contact();
            c.setTaxpayer(tp);
            c.setTypeOfContact("E-mail");
            c.setValue(email);
            if (!tp.getRights().equals(rights)) {
                tp.setPassword(password);
                tp.setRights(rights);
                Factory.getInstance().getTaxpayerDAO().updateTaxpayer(tp);
                Factory.getInstance().getContactDAO().addContact(c);
                return true;
            } else {
                throw new AttemptionToRepeatRegistration();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
