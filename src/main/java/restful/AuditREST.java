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
import restful.resources.*;

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
          //  PermissionCheck.check(token);
            JSONArray tarray = AuditRes.getAllAudit(id);
            response = tarray;
            return Response.status(200).entity(response.toString()).build();
        } catch (AuthSecurityException e) {
            String resp = "ACCESS DENIED";
            return Response.status(403).entity(resp).build();
    /*    } catch (PermissionException e) {
            String resp = "YOU HAVE NOT ENOUGH PERMISSION TO PERFORM THIS ACTION";
            return Response.status(403).entity(resp).build(); */
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
       //     PermissionCheck.check(token);
            response = new JSONArray();
            response.put(AuditRes.getAuditByID(audit_id));
            response.put(DecisionRes.getDecisionsByAuditId(audit_id));
            response.put(ReferralRes.getReferralsByAuditId(audit_id));
            String s = response.toString();
            return Response.status(200).entity(s).build();
        } catch (AuthSecurityException e) {
            String resp = "ACCESS DENIED";
            return Response.status(403).entity(resp).build();
  /*      } catch (PermissionException e) {
            String resp = "YOU HAVE NOT ENOUGH PERMISSION TO PERFORM THIS ACTION";
            return Response.status(403).entity(resp).build(); */
        }catch (JSONException e) {
            e.printStackTrace();
            return Response.status(400).build();
        }
    }

    @Path("/{audit_id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeAudit(@PathParam("id") long id, @PathParam("audit_id") long audit_id,
                             @QueryParam("action") String action, String src) {
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s = AuditRes.performAction(action, id, audit_id, new JSONObject(src)).toString();
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addAudit(@PathParam("id") long id, @QueryParam("action") String action, String src) {
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s = AuditRes.performAction(action, id, id, new JSONObject(src)).toString();
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



    /*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*/
    /*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*/
    /*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*/
    /*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*/
    /*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*//*DECISION BLOCK*/



    /**
     * @param id
     * @param audit_id
     * @param src
     * @return
     */
    @Path("/{audit_id}/decision")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getDecisions(@PathParam("id") long id, @PathParam("audit_id") long audit_id, String src) {
      //  JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s = DecisionRes.getDecisionsByAuditId(audit_id).toString();
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

    @Path("/{audit_id}/decision")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addDecision(@PathParam("id") long id, @PathParam("audit_id") long audit_id,
                                 @QueryParam("action") String action, String src) {
        //  JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s = DecisionRes.performAction(action, audit_id, 0, new JSONObject(src)).toString();
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

    @Path("/{audit_id}/decision/{decision_id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeDecision(@PathParam("id") long id, @PathParam("audit_id") long audit_id,
                                 @PathParam("decision_id") long decision_id,
                                 @QueryParam("action") String action, String src) {
        //  JSONArray response;
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s = DecisionRes.performAction(action, audit_id, decision_id, new JSONObject(src)).toString();
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


    /*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*/
    /*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*/
    /*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*/
    /*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*//*REFERRAL BLOCK*/

    /*ATTENTION! VERY AFFECTIVE TO CHANGES*/

    /*********************************************************************
     * BIG
     * AMOUNT
     * OF
     * PROBLEMS
     * *******************************************************************
     *
     *
     * @param id
     * @param audit_id
     * @param src
     * @return
     */

    @Path("/{audit_id}/referral")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getReferrals(@PathParam("id") long id, @PathParam("audit_id") long audit_id, String src) {
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s  = ReferralRes.getReferralsByAuditId(audit_id).toString();
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

    @Path("/{audit_id}/referral")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addReferral(@PathParam("id") long id, @PathParam("audit_id") long audit_id,
                                 @QueryParam("action") String action, String src) {
        try {
            JSONObject j = new JSONObject(src);
            String token = j.optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s  = ReferralRes.performAction(action, 0, audit_id, j.optLong("employee_id"),
                    j.optLong("decree_id"), j).toString();
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

    @Path("/{audit_id}/referral/{referral_id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getReferral(@PathParam("id") long id, @PathParam("audit_id") long audit_id,
                                 @PathParam("referral_id") long referral_id, String src) {
        try {
            String token = new JSONObject(src).optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s  = ReferralRes.getReferralyById(referral_id).toString();
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

    @Path("/{audit_id}/referral/{referral_id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeReferral(@PathParam("id") long id, @PathParam("audit_id") long audit_id,
                                @PathParam("referral_id") long referral_id,
                                @QueryParam("action") String action, String src) {
        try {
            JSONObject j = new JSONObject(src);
            String token = j.optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            String s  = ReferralRes.performAction(action, referral_id, audit_id, j.optLong("employee_id"),
                    j.optLong("decree_id"), j).toString();
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

    @Path("/{audit_id}/referral/{referral_id}/decree")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeDecree(@PathParam("id") long id, @PathParam("audit_id") long audit_id,
                                   @PathParam("referral_id") long referral_id,
                                   @QueryParam("action") String action, String src) {
        try {
            JSONObject j = new JSONObject(src);
            String token = j.optString("token");
            AuthCheck.check(token);
            PermissionCheck.check(token);
            DecreeRes.addDecree(j);
            String s  = ReferralRes.performAction(action, referral_id, audit_id, j.optLong("employee_id"),
                    j.optLong("decree_id"), j).toString();
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
