package restful;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 * This class used for:
 * providing authentification of users into system
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

    /**
     * log into system wit usrename and password
     * @param inp
     * @return token
     */
    @PUT
    public Response logIN(String inp) {
        JSONObject src;
        try {
            src = new JSONObject(inp);
            String username = src.optString("username");
            int pass = src.optString("password").hashCode();
            LoginRes.check(username, pass);
            JSONObject j= new JSONObject();
            j.put("token", TokenGenerator.generate(username));
            String s = j.toString();
            return Response.status(200).entity(s).build();
        } catch (WrongLoginPasswordException e) {
            String resp = "Wrong username/password";
            return Response.status(403).entity(resp).build();
        } catch (JSONException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }

    /**
     * log out of system with a token
     * @param action
     * @param src
     * @return
     */
    @POST
    public Response logOUT(@QueryParam("action") String action,
                                                     String src) {
            JSONObject j;
        try {
            j = new JSONObject(src);
            String token = j.optString("token");
            AuthCheck.check(token);
            String s = "";
            if (action.equals("logout")) {
                LoginRes.logOut(token);
                s = "SUCCESS";
            } else {
                s = "Wrong querry";
            }
            return Response.status(200).entity(s).build();
        } catch (JSONException e) {
            e.printStackTrace();
            return Response.status(400).build();
        } catch (AuthSecurityException e) {
            return Response.status(403).entity("You're not authorized").build();
        }
    }
}
