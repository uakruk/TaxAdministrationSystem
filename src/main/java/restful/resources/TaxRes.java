package restful.resources;

import dao.Factory;
import dao.TaxDAO;
import dao.TaxpayerDAO;
import logic.Taxpayer;
import logic.Tax;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 16.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public class TaxRes {

    private static Factory factory = Factory.getInstance();
    private static TaxDAO dao = factory.getTaxDAO();
    private static TaxDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getTaxDAO() : dao;
        return dao;
    }

    /**
     * get taxes by taxpayer_id
     * @param src
     * @return
     */
    public JSONArray getAllTaxesById(JSONObject src) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            TaxpayerDAO tdao = factory.getTaxpayerDAO();
            Collection<Tax> col = tdao.getTaxpayerById(src.optLong("taxpayer_id"))
                    .getTaxes();
            Iterator<Tax> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Tax t = iter.next();
                temp.put("tax_id", t.getTax_id());
                temp.put("typeOfTax", t.getTypeOfTax());
                temp.put("startDate", t.getStartDate().toString());
                temp.put("endDate", t.getEndDate().toString());
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

    /**
     * get tax by tax_id
     * @param src
     * @return
     */
    public JSONObject getTaxById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Tax t = dao.getTaxById(src.optLong("tax_id"));
            temp.put("tax_id", t.getTax_id());
            temp.put("typeOfTax", t.getTypeOfTax());
            temp.put("startDate", t.getStartDate().toString());
            temp.put("endDate", t.getEndDate().toString());
            temp.put("MSG", "Item has been delivered successfully");
            temp.put("HTTP_CODE", "200");
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while processing a JSON");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                e.printStackTrace();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * update tax by tax_id
     * @param src
     * @return
     */
    public JSONObject updateTaxById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Tax t = dao.getTaxById(src.optLong("tax_id"));
            t.setTypeOfTax(src.optString("typeOfTax"));
            t.setStartDate(new Date(src.optLong("startDate")));
            t.setEndDate(new Date(src.optLong("endDate")));
            dao.updateTax(t);
            temp.put("MSG", "Item has been updated successfully");
            temp.put("HTTP_CODE", "200");
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while processing a JSON");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                e.printStackTrace();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * add tax by taxpayer_id
     * @param src
     * @return
     */
    public JSONObject addTaxByTaxpayerId(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Taxpayer tp = factory.getTaxpayerDAO().getTaxpayerById(src.optLong("taxpayer_id"));
            Tax t = new Tax();
            t.setTypeOfTax(src.optString("typeOfTax"));
            t.setStartDate(new Date(src.optLong("startDate")));
            t.setEndDate(new Date(src.optLong("endDate")));
            t.setTaxpayer(tp);
            dao.addTax(t);
            temp.put("MSG", "Item has been added successfully");
            temp.put("HTTP_CODE", "200");
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while processing a JSON");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                e.printStackTrace();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }
}
