package restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;

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

@Path("/taxpayer/{id}/charges/{chargeid}")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AdditionalChargesREST {

    @GET
    public Response getChargeById(@PathParam("id") long taxpayerID,
                                  @PathParam("chargeid") long chargeID,
                                  String inputData) {
        JSONObject obj;
        JSONObject resp;
        try {
            obj = new JSONObject(inputData);
            AuthCheck auth = new AuthCheck();
            auth.check(obj.optString("token"));
                resp = AdditionalChargeesRes.getAdditionalCharges(chargeID);

        } catch (JSONException e) {
            e.printStackTrace();
            resp = new JSONObject();
        } catch (restful.Security.SecurityException b) {
            b.printStackTrace();
            resp = new JSONObject();
        }
        return Response.ok().entity(resp.toString()).build();
    }
}
