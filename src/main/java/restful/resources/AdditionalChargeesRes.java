package restful.resources;

import dao.TaxDAO;
import logic.AdditionalCharges;
import logic.Tax;
import logic.Taxpayer;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import dao.Factory;
import dao.AdditionalChargesDAO;

import java.sql.Date;


/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 14.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public abstract class AdditionalChargeesRes {

    public static JSONObject getAdditionalCharges(JSONObject src) {
        JSONObject obj = new JSONObject();
        Factory factory = Factory.getInstance();
        AdditionalChargesDAO dao = factory.getAdditionalChargesDAO();
        try {
            AdditionalCharges ac = dao.getAdditionalChargesById(src.optLong("additionalCharges_id"));
            obj.put("additionalCharges_id", ac.getAdditionalCharges_id());
            obj.put("sum", ac.getSum());
            obj.put("dateOfCharge", ac.getDateOfCharge().toString());
            obj.put("term", ac.getTerm().toString());
            obj.put("typeOfAdditionalCharge", ac.getTypeOfAdditionalCharge());
            obj.put("MSG", "OK");
            obj.put("HTTP_CODE", "200");
        } catch (Exception e) {
            e.printStackTrace();
            obj = new JSONObject();
            try {
                obj.put("MSG", "ERROR");
                obj.put("HTTP_CODE", "500");
            } catch (JSONException ec) {
                ec.printStackTrace();
            }

        }
        return obj;
    }

    public static JSONObject updateAdditionalCharges(JSONObject source) {
        JSONObject obj = new JSONObject();
        Factory factory = Factory.getInstance();
        AdditionalChargesDAO dao = factory.getAdditionalChargesDAO();
        try {
            AdditionalCharges ac = dao.getAdditionalChargesById(source.getLong("additionalCharges_id"));
          //  source.("additionalCharges_id");
            ac.setSum(source.optDouble("sum"));
            ac.setDateOfCharge(new Date(source.optLong("dateOfCharge")));
            ac.setTerm(new Date(source.optLong("term")));
            ac.setTypeTypeOfAdditionalCharge(source.optString("typeOfAdditionalCharge"));
            dao.updateAdditionalCharges(ac);
            obj.put("MSG", "OK");
            obj.put("HTTP_CODE", "200");
        } catch (Exception e) {
            e.printStackTrace();
            obj = new JSONObject();
            try {
                obj.put("MSG", "ERROR");
                obj.put("HTTP_CODE", "500");
            } catch (JSONException ec) {
                ec.printStackTrace();
            }

        }
        return obj;
    }

    /**
     * source contains all necessary information + taxID in source
     * @param source
     * @return
     */
    public static JSONObject addAdditionalCharges(JSONObject source) {
        JSONObject obj = new JSONObject();
        Factory factory = Factory.getInstance();
        AdditionalChargesDAO dao = factory.getAdditionalChargesDAO();
        TaxDAO tdao = factory.getTaxDAO();
        try {
            AdditionalCharges ac = new AdditionalCharges();
            //  source.("additionalCharges_id");
            ac.setSum(source.optDouble("sum"));
            ac.setDateOfCharge(new Date(source.optLong("dateOfCharge")));
            ac.setTerm(new Date(source.optLong("term")));
            ac.setTypeTypeOfAdditionalCharge(source.optString("typeOfAdditionalCharge"));
            ac.setTax(tdao.getTaxById(source.optLong("taxID")));
            dao.addAdditionalCharges(ac);
            obj.put("MSG", "OK");
            obj.put("HTTP_CODE", "200");
        } catch (Exception e) {
            e.printStackTrace();
            obj = new JSONObject();
            try {
                obj.put("MSG", "ERROR");
                obj.put("HTTP_CODE", "500");
            } catch (JSONException ec) {
                ec.printStackTrace();
            }
        }
        return obj;
    }
}
