package restful;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.*;
import restful.resources.AdditionalChargeesRes;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 14.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */

@Path("/taxpayer/{id}/tax/{tax_id}/charge")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdditionalChargesREST {

    @POST
    public Response getAllCharges(@PathParam("id") long id,
                                   @PathParam("tax_id") long tax_id,
                                   String src) {
        JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.checkRead(token, "Charge");
            response = AdditionalChargeesRes.getAllCharges(tax_id);
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
    public Response addCharge(@PathParam("id") long id,
                               @PathParam("tax_id") long tax_id,
                               String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.specialCheck(token);
            response = AdditionalChargeesRes.addAdditionalCharges(tax_id, new JSONObject(src));
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

    @POST
    @Path("/{charge_id}")
    public Response getCharge(@PathParam("id") long id,
                               @PathParam("tax_id") long tax_id,
                               @PathParam("charge_id") long charge_id,
                               String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.checkRead(token, "Charge");
            response = AdditionalChargeesRes.getAdditionalCharges(charge_id);
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

    @POST
    @Path("/{charge_id}")
    public Response changeCharge(@PathParam("id") long id,
                                  @PathParam("tax_id") long tax_id,
                                  @PathParam("charge_id") long charge_id,
                                  @QueryParam("action") String action,
                                  String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.checkWrite(token, "Charge");
            response = action.equals("change") ?
                    AdditionalChargeesRes.updateAdditionalCharges(charge_id, new JSONObject(src)) :
                    AdditionalChargeesRes.getAdditionalCharges(charge_id);
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
