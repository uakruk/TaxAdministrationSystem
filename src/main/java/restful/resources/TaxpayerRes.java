package restful.resources;

import dao.Factory;
import dao.TaxpayerDAO;
import logic.Taxpayer;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.sql.SQLException;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 16.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public abstract class TaxpayerRes {

    private static Factory factory = Factory.getInstance();
    private static TaxpayerDAO dao = factory.getTaxpayerDAO();
    private static TaxpayerDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getTaxpayerDAO() : dao;
        return dao;
    }

    public static synchronized JSONObject performAction(String action, long ID, JSONObject obj) {
        return  action.equals("change") ? updateTaxpayerById(ID, obj) : getTaxpayerById(ID);
    }

    /**
     * get taxpayer by taxpayer_id
     * @param ID
     * @return
     */
    public static JSONObject getTaxpayerById(long ID) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Taxpayer t = dao.getTaxpayerById(ID);
            temp.put("taxpayer_id", t.getTaxpayer_id());
            temp.put("fullName", t.getFullName());
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
     * update taxpayer by taxpayer_id
     * @param ID
     * @return
     */
    public static synchronized JSONObject updateTaxpayerById(long ID, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Taxpayer t = dao.getTaxpayerById(ID);
            t.setFullName(src.optString("fullName"));
            dao.updateTaxpayer(t);
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
     * add taxpayer by taxpayer_id
     * @param src
     * @return
     */
    public static synchronized JSONObject addTaxpayer(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Taxpayer t = new Taxpayer();
            t.setFullName(src.optString("fullName"));
            dao.addTaxpayer(t);
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
