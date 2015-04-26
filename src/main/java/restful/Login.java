package restful;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
<<<<<<< HEAD
import restful.Security.*;
=======
import restful.Security.TokenGenerator;
import restful.Security.WrongLoginPasswordException;
import restful.resources.LoginRes;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3

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
<<<<<<< HEAD
@Consumes({MediaType.APPLICATION_JSON, "text/plain"})
public class Login {

    @PUT
    public Response logIN(String inp) {
        JSONObject src;
        try {
            src = new JSONObject(inp);
=======
@Consumes(MediaType.APPLICATION_JSON)
public class Login {

    @POST
    public Response logIN(JSONObject src) {
        try {
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
            String username = src.optString("username");
            int pass = src.optString("password").hashCode();
            LoginRes.check(username, pass);
            JSONObject j= new JSONObject();
<<<<<<< HEAD
            j.put("token", TokenGenerator.generate(username));
=======
            j.put("token", TokenGenerator.generate(src));
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
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
<<<<<<< HEAD

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
=======
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
}
