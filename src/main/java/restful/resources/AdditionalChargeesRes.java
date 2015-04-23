package restful.resources;

import dao.TaxDAO;
import logic.AdditionalCharges;
import logic.Tax;
import logic.Taxpayer;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import dao.Factory;
import dao.AdditionalChargesDAO;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;


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


    public static JSONArray getAllCharges(long tax_id) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            AdditionalChargesDAO dao = Factory.getInstance().getAdditionalChargesDAO();
            TaxDAO tdao= Factory.getInstance().getTaxDAO();
            Collection<AdditionalCharges> col = tdao.getTaxById(tax_id)
                    .getAdditionalCharges();
            Iterator<AdditionalCharges> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                AdditionalCharges ac = iter.next();
                temp.put("additionalCharges_id", ac.getAdditionalCharges_id());
                temp.put("sum", ac.getSum());
                temp.put("dateOfCharge", ac.getDateOfCharge().toString());
                temp.put("term", ac.getTerm().toString());
                temp.put("typeOfAdditionalCharge", ac.getTypeOfAdditionalCharge());
                resp.put(temp);
            }
            temp = new JSONObject();
            temp.put("MSG", "Items have been delivered successfully");
            temp.put("HTTP_CODE", "200");
            resp.put(temp);
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while processing a JSON");
                temp.put("HTTP_CODE", "500");
                resp.put(temp);
            } catch (JSONException n) {
                e.printStackTrace();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
                resp.put(temp);
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return resp;
    }

    public static JSONObject getAdditionalCharges(long charge) {
        JSONObject obj = new JSONObject();
        Factory factory = Factory.getInstance();
        AdditionalChargesDAO dao = factory.getAdditionalChargesDAO();
        try {
            AdditionalCharges ac = dao.getAdditionalChargesById(charge);
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

    public static synchronized JSONObject updateAdditionalCharges(long charge_id,
                                                                  JSONObject source) {
        JSONObject obj = new JSONObject();
        Factory factory = Factory.getInstance();
        AdditionalChargesDAO dao = factory.getAdditionalChargesDAO();
        try {
            AdditionalCharges ac = dao.getAdditionalChargesById(charge_id);
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
    public static synchronized JSONObject addAdditionalCharges(long tax_id,
                                                               JSONObject source) {
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
            ac.setTax(tdao.getTaxById(tax_id));
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
