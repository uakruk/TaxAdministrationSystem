package restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam
import javax.ws.rs.Consumes;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import dao.Factory;
import dao.AuditDAO;

import logic.Audit;
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

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getTaxpayerAudit(@PathParam("id") long id, String incomingData) {
        int http_code;
        String returnString = null;
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        try {
            JSONObject jdata = new JSONObject(incomingData);
            JSONObject temp = new JSONObject();
            //security check
            Factory factory = Factory.getInstance();
            AuditDAO dao = factory.getAuditDAO();
            Audit daudit;
            while(dao.getAllAudit().iterator().hasNext()) {
                daudit = (Audit)dao.getAllAudit().iterator().next();
                temp.put("startDate", daudit.getStartDate().toString());
                temp.put("endDate", daudit.getEndDate().toString());
                temp.put("registrationNumber", daudit.getRegistrationNumber());
                temp.put("comment", daudit.getComment());
                temp.put("reason", daudit.getReason());
             //   temp.put("refferal", daudit.getReferrals());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
