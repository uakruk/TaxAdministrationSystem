package restful.resources;

import logic.Unit;
import dao.Factory;
import dao.UnitDAO;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
public class UnitRes {

    private static Factory factory = Factory.getInstance();
    private static UnitDAO dao = factory.getUnitDAO();
    private static UnitDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getUnitDAO() : dao;
        return dao;
    }

    /**
     * get unit by unit_id
     * @param src
     * @return
     */
    public JSONObject getUnitById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Unit u = dao.getUnitById(src.optLong("unit_id"));
            temp.put("unit_id", u.getUnit_id());
            temp.put("title", u.getTitle());
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
     * update unit by unit_id
     * @param src
     * @return
     */
    public JSONObject updateUnitById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Unit u = dao.getUnitById(src.optLong("unit_id"));
            u.setTitle(src.optString("title"));
            dao.updateUnit(u);
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
     * add new unit
     * @param src
     * @return
     */
    public JSONObject addUnit(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Unit u = new Unit();
            u.setTitle(src.optString("title"));
            dao.addUnit(u);
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

    /**
     * delete Unit by unit_id
     * @param src
     * @return
     */
    public JSONObject deleteUnityById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Unit u = dao.getUnitById(src.optLong("unit_id"));
            dao.deleteUnit(u);
            temp.put("MSG", "Item has been deleted successfully");
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
