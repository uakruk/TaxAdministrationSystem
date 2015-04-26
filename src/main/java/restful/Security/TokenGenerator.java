package restful.Security;

<<<<<<< HEAD
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.resources.TaxpayerRes;

=======
import org.codehaus.jettison.json.JSONObject;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3

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

<<<<<<< HEAD
    public static String generate(String inputData) {
        JSONObject j;
     //   try {
            j = TaxpayerRes.getTaxpayerById(Long.parseLong(inputData));
            String name = j.optString("name");
            /*generatino*/
      /*  } catch (JSONException e) {
            e.printStackTrace(); */
    //     }
=======
    public static String generate(JSONObject s) {
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
        return "trololo;";
    }
}
