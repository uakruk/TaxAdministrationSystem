package restful;


import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
//import restful.Security.TokenGenerator;
import restful.Security.AttemptionToRepeatRegistration;
<<<<<<< HEAD
=======
import restful.Security.WrongLoginPasswordException;
import restful.resources.LoginRes;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
import restful.resources.Registrator;

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

@Path("/register")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class Registration {

    @POST
    public Response register(String src) {
        try {
            JSONObject j = new JSONObject(src);
            Registrator.register(j);
            String s = j.toString();
            return Response.status(200).entity(s).build();
        } catch (JSONException e) {
            e.printStackTrace();
            return Response.status(400).build();
        } catch (AttemptionToRepeatRegistration e) {
            e.printStackTrace();
            return Response.status(300).entity("Account with these parameters does exist already!").build();
        }
    }

}
