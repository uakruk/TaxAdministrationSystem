package restful.resources;

import org.codehaus.jettison.json.JSONObject;
import restful.Security.AttemptionToRepeatRegistration;

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
        return true;
    }
}
