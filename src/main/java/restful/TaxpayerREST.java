package restful;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.*;
import restful.resources.ContactRes;
import restful.resources.TaxpayerRes;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 13.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
@Path("/taxpayer")
@Produces(MediaType.APPLICATION_JSON)
public class TaxpayerREST {

    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Response getGeneralInfo(@PathParam("id") long id, String src) {
        JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            JSONObject temp  = TaxpayerRes.getTaxpayerById(id);
            JSONArray tarray = ContactRes.getAllContactsById(id);
            tarray.put(temp);
            response = tarray;
            return Response.status(200).entity(response.toString()).build();
        } catch (AuthSecurityException e) {
            String resp = "ACCESS DENIED";
            return Response.status(403).entity(resp).build();
        } catch (PermissionException e) {
            String resp = "YOU HAVE NOT ENOUGH PERMISSION TO PERFORM THIS ACTION";
            return Response.status(403).entity(resp).build();
        }  catch (JSONException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }

    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Response changeGeneralInfo(@PathParam("id") long id, @QueryParam("action") String action, String src) {
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s = action.equals("change") ?
                    TaxpayerRes.updateTaxpayerById(id, new JSONObject(src)).toString() :
                    TaxpayerRes.getTaxpayerById(id).toString();
            return Response.status(200).entity(s).build();
        } catch (AuthSecurityException e) {
            String resp = "ACCESS DENIED";
            return Response.status(403).entity(resp).build();
        } catch (PermissionException e) {
            String resp = "YOU HAVE NOT ENOUGH PERMISSION TO PERFORM THIS ACTION";
            return Response.status(403).entity(resp).build();
        }catch (JSONException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }

    @Consumes(MediaType.APPLICATION_JSON)
    @PUT
    public Response addTaxpayer(String src) {
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s = TaxpayerRes.addTaxpayer(new JSONObject(src)).toString();
            return Response.status(200).entity(s).build();
        } catch (AuthSecurityException e) {
            String resp = "ACCESS DENIED";
            return Response.status(403).entity(resp).build();
        } catch (PermissionException e) {
            String resp = "YOU HAVE NOT ENOUGH PERMISSION TO PERFORM THIS ACTION";
            return Response.status(403).entity(resp).build();
        }catch (JSONException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }
}