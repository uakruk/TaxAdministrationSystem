package restful;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.AuthCheck;
import restful.Security.AuthSecurityException;
import restful.Security.PermissionCheck;
import restful.Security.PermissionException;
import restful.resources.CashRegisterRes;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 18.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */

@Path("/taxpayer/{id}/taxitionobject/{taxition_id}/cashregister")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CashRegisterREST {

    @POST
    public Response getAllCashRegister(@PathParam("id") long id,
                                          @PathParam("taxition_id") long taxition_id,
                                          String src) {
        JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = CashRegisterRes.getAllashRegistersById(taxition_id);
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

    @PUT
    public Response addCashRegister(@PathParam("id") long id,
                                          @PathParam("taxition_id") long taxition_id,
                                          String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = CashRegisterRes.addCashRegister(taxition_id, new JSONObject(src));
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

    /**
     * DELETE CASH REGISTER BY QUERRY REQUEST LIKE ?delete=1245
     * @param id
     * @param taxition_id
     * @param cash_id
     * @param src
     * @return
     */
    @DELETE
    public Response deleteCashRegister(@PathParam("id") long id,
                                    @PathParam("taxition_id") long taxition_id,
                                    @QueryParam("delete") long cash_id,
                                    String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = CashRegisterRes.deleteCashRegisterById(cash_id);
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
}
