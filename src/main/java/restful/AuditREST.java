package restful;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import dao.Factory;
import dao.AuditDAO;

import logic.Audit;
import restful.Security.AuthCheck;
import restful.Security.AuthSecurityException;
import restful.Security.PermissionCheck;
import restful.Security.PermissionException;
import restful.resources.AuditRes;
import restful.resources.DecisionRes;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 13.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
@Path("taxpayer/{id}/audit")
@Produces(MediaType.APPLICATION_JSON)
public class AuditREST {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllAudit(@PathParam("id") long id, String src) {
        JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            JSONArray tarray = AuditRes.getAllAudit(id);
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
    @Path("/{audit_id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAudit(@PathParam("id") long id, @PathParam("audit_id") long audit_id, String src) {
        JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = new JSONArray();
            response.put(AuditRes.getAuditByID(audit_id));
            response.put(DecisionRes.
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

    @Path("/{audit_id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeAudit(@PathParam("id") long id, @PathParam("audit_id") long audit_id,
                             @QueryParam("actiion") String action, String src) {
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s = AuditRes.performAction(action, audit_id, new JSONObject(src)).toString();
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
