package restful;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.AuthCheck;
import restful.Security.AuthSecurityException;
import restful.Security.PermissionCheck;
import restful.Security.PermissionException;
import restful.resources.LicenseRes;
import restful.resources.ObjectOfTaxitionRes;

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

@Path("taxpayer/{id}/taxitionobject")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TaxitionObjectREST {

    @POST
    public Response getAllTaxitionObjects(@PathParam("id") long id,
                                   String src) {
        JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.checkRead(token, "Registration");
            response = ObjectOfTaxitionRes.getAllObjectsOfTaxitionById(id);
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
    public Response addTaxitionObject(@PathParam("id") long id,
                                                         String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.checkWrite(token, "Registration");
            response = ObjectOfTaxitionRes.addObjectOfTaxition(id, new JSONObject(src));
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

    @Path("/{taxition_id}")
    @POST
    public Response getTaxition(@PathParam("id") long id,
                                   @PathParam("taxition_id") long taxition_id,
                                          String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.checkRead(token, "Registration");
            response = ObjectOfTaxitionRes.getObjectOfTaxitionById(taxition_id);
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
     * UPDATE TAXITION OBJECT
     * @param id
     * @param taxition_id
     * @param action
     * @param src
     * @return
     */
    @Path("/{taxition_id}")
    @POST
    public Response changeTaxition(@PathParam("id") long id,
                                @PathParam("taxition_id") long taxition_id,
                                @QueryParam("action") String action,
                                String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.checkWrite(token, "Registration");
            response = action.equals("change") ?
                    ObjectOfTaxitionRes.updateObjectOfTaxitionById(id, new JSONObject(src)) :
                    ObjectOfTaxitionRes.getObjectOfTaxitionById(taxition_id);
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

    @Path("/{taxition_id}")
    @DELETE
    public Response deleteTaxition(@PathParam("id") long id,
                                   @PathParam("taxition_id") long taxition_id,
                                   @QueryParam("action") String action,
                                   String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.checkWrite(token, "Registration");
            response = action.equals("change") ?
                    ObjectOfTaxitionRes.deleteObjectOfTaxitionById(taxition_id) :
                    ObjectOfTaxitionRes.getObjectOfTaxitionById(taxition_id);
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
/*
    @Path("/{taxition_id}")
    @PUT
    public Response addLicense(@PathParam("id") long id,
                                   @PathParam("taxition_id") long taxition_id,
                                   @QueryParam("action") String action,
                                   String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = action.equals("addLicense") ?
                    LicenseRes.update
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
    } */
}
