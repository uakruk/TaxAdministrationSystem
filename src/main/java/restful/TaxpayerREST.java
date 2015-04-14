package restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.QueryParam;
import javax.ws.rs.Consumes;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
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
    public Response getGeneralInfo(@PathParam("id") long id) {

    }
}