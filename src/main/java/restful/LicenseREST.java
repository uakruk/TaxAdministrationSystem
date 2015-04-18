package restful;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.AuthCheck;
import restful.Security.AuthSecurityException;
import restful.Security.PermissionCheck;
import restful.Security.PermissionException;
import restful.resources.LicenseRes;
import restful.resources.TaxpayerRes;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 18.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */

@Path("/taxpayer/{id}/license")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class LicenseREST {

    @POST
    public Response getLicenses(@PathParam("id") long id, String src) {
        JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = LicenseRes.getAllLicensesById(id);
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
    @Path("/{license_id}")
    public Response getLicense(@PathParam("id") long id,
                               @PathParam("license_id") long license_id, String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = LicenseRes.getLicenseById(license_id);
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
    @Path("/{license_id}")
    public Response changeLicense(@PathParam("id") long id,
                               @PathParam("license_id") long license_id,
                               @QueryParam("action") String action, String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = LicenseRes.performAction(action, id, license_id, new JSONObject(src));
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
    public Response addLicense(@PathParam("id") long id,
                               @QueryParam("action") String action, String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = LicenseRes.performAction(action, id, 0, new JSONObject(src));
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
