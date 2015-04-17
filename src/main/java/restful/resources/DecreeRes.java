package restful.resources;

import dao.DecreeDAO;
import dao.Factory;
import logic.Decree;
import logic.Referral;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONException;

import java.sql.SQLException;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 14.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public class DecreeRes {

    /*something fuckable*/
    private static Factory factory = Factory.getInstance();
    private static DecreeDAO dao = factory.getDecreeDAO();
    private static DecreeDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getDecreeDAO() : dao;
        return dao;
    }

    /**
     * get decree by decree_id
     * @param src
     * @return
     */
    public JSONObject getDecreeById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Decree d =dao.getDecreeById(src.optLong("decree_id"));
            temp.put("decree_id", d.getDecree_id());
            temp.put("registrationNumber", d.getRegiastrationNumber());
            temp.put("signaturedByWho", d.getSignaturedByWho());
            temp.put("text", d.getText());
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
     * update decree by decree_id
     * @param src
     * @return
     */
    public JSONObject updateDecreeById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Decree d =dao.getDecreeById(src.optLong("decree_id"));
            d.setRegiastrationNumber(src.optLong("registrationNumber"));
            d.setSignaturedByWho(src.optString("signaturedByWho"));
            d.setText(src.optString("text"));
            dao.updateDecree(d);
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
     * add decree
     * @param src
     * @return
     */
    public JSONObject addDecree(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Decree d = new Decree();
            d.setRegiastrationNumber(src.optLong("registrationNumber"));
            d.setSignaturedByWho(src.optString("signaturedByWho"));
            d.setText(src.optString("text"));
            dao.addDecree(d);
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
