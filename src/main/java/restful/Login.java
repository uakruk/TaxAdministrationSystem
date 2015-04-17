package restful;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.TokenGenerator;
import restful.Security.WrongLoginPasswordException;
import restful.resources.LoginRes;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 17.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */

@Path("/login")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Login {

    @POST
    public Response logIN(JSONObject src) {
        try {
            String username = src.optString("username");
            int pass = src.optString("password").hashCode();
            LoginRes.check(username, pass);
            JSONObject j= new JSONObject();
            j.put("token", TokenGenerator.generate(src));
            String s = j.toString();
            return Response.status(200).entity(s).build();
        } catch (WrongLoginPasswordException e) {
            String resp = "Wrong username/password";
            return Response.status(403).entity(resp).build();
        }catch (JSONException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }
}
