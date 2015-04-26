package restful.Security;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.resources.TaxpayerRes;


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
        JSONObject j;
     //   try {
            j = TaxpayerRes.getTaxpayerById(Long.parseLong(inputData));
            String name = j.optString("name");
        /** permission generation*/
            /*generatino*/
      /*  } catch (JSONException e) {
            e.printStackTrace(); */
    //     }
        return "trololo;";
    }
}
