package restful;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import restful.Security.AuthCheck;
import restful.Security.AuthSecurityException;
import restful.Security.PermissionCheck;
import restful.Security.PermissionException;
import restful.resources.EmployeeRes;
import restful.resources.UnitRes;
import wrappers.Employee;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 20.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */

@Path("/unit")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UnitREST {

    @POST
    public Response getAllUnits(String src) {
        JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = UnitRes.getAllUnits();
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
    public Response addUnit(String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = UnitRes.addUnit(new JSONObject(src));
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
    @Path("/{unit_id}")
    public Response getUnitStaff(@PathParam("unit_id") long unit_id,
                                                        String src) {
        JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = EmployeeRes.getAllEmployeesByUnitId(unit_id);
            response.put(UnitRes.getUnitById(unit_id));
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
    @Path("/{unit_id}")
    public Response changeUnit(@PathParam("unit_id") long unit_id,
                                   @QueryParam("action") String action, String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = action.equals("change") ?
                    UnitRes.updateUnitById(unit_id, new JSONObject(src)) :
                    UnitRes.getUnitById(unit_id);
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

    @DELETE
    @Path("/{unit_id}")
    public Response deleteUnit(@PathParam("unit_id") long unit_id,
                                   @QueryParam("action") String action, String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = action.equals("delete") ?
                    UnitRes.deleteUnityById(unit_id) :
                    UnitRes.getUnitById(unit_id);
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
    @Path("/{unit_id}")
    public Response addEmployee(@PathParam("unit_id") long unit_id, String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = EmployeeRes.addEmployeeByUnitId(unit_id, new JSONObject(src));
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
    @Path("/{unit_id}/staff/{employee_id}")
    public Response changeEmployee(@PathParam("unit_id") long unit_id,
                                  @PathParam("employee_id") long employee_id,
                               @QueryParam("action") String action, String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = action.equals("change") ?
                    EmployeeRes.updateEmployeeById(employee_id, new JSONObject(src)) :
                    EmployeeRes.getEmployeeById(employee_id);
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

    @DELETE
    @Path("/{unit_id}/staff/{employee_id}")
    public Response deleteUnit(@PathParam("unit_id") long unit_id,
                               @PathParam("employee_id") long employee_id,
                               @QueryParam("action") String action, String src) {
        JSONObject response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            response = action.equals("delete") ?
                    EmployeeRes.deleteEmployeeById(employee_id) :
                    EmployeeRes.getEmployeeById(employee_id);
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
