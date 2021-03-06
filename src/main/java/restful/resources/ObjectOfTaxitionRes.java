package restful.resources;

import dao.ContactDAO;
import dao.Factory;
import dao.ObjectOfTaxationDAO;
import dao.TaxpayerDAO;
import logic.ObjectOfTaxation;
import logic.Taxpayer;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONException;

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
public abstract class ObjectOfTaxitionRes {

    private static Factory factory = Factory.getInstance();
    private static ObjectOfTaxationDAO dao = factory.getObjectOfTaxationDAO();
    private static ObjectOfTaxationDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getObjectOfTaxationDAO() : dao;
        return dao;
    }

    public static JSONObject performAction(String action, long taxpayer_id,
                                           long taxition_id, JSONObject src) {
        return action.equals("change") ? updateObjectOfTaxitionById(taxition_id, src) :
                action.equals("add") ? addObjectOfTaxition(taxpayer_id, src) :
                        action.equals("delete") ? deleteObjectOfTaxitionById(taxition_id) :
                                getObjectOfTaxitionById(taxition_id);
    }

    /**
     * get objects of taxition by taxpayer_id
     * @param src
     * @return
     */
    public static JSONArray getAllObjectsOfTaxitionById(long taxpayer_id) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            TaxpayerDAO tdao = factory.getTaxpayerDAO();
            Collection<ObjectOfTaxation> col = tdao.getTaxpayerById(taxpayer_id)
                    .getObjectOfTaxations();
            Iterator<ObjectOfTaxation> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                ObjectOfTaxation o = iter.next();
                temp.put("objectOfTaxition_id", o.getObjectOfTaxation_id());
                temp.put("title", o.getTitle());
                temp.put("address", o.getAddress());
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
     * get object of taxition by objectOfTaxition_id
     * @param src
     * @return
     */
    public static JSONObject getObjectOfTaxitionById(long taxition_id) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            ObjectOfTaxation o = dao.getObjectOfTaxationById(taxition_id);
            temp.put("objectOfTaxition_id", o.getObjectOfTaxation_id());
            temp.put("title", o.getTitle());
            temp.put("address", o.getAddress());
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
     * update object of taxition by objectOfTaxition_id
     * @param src
     * @return
     */
    public static synchronized JSONObject updateObjectOfTaxitionById(long taxition_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            ObjectOfTaxation o = dao.getObjectOfTaxationById(taxition_id);
            o.setAddress(src.optString("address"));
            o.setTitle(src.optString("title"));
            dao.updateObjectOfTaxation(o);
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
     * add object of taxition by taxpayer_id
     * @param src
     * @return
     */
    public static synchronized JSONObject addObjectOfTaxition(long taxpayer_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Taxpayer tp = factory.getTaxpayerDAO().getTaxpayerById(taxpayer_id);
            ObjectOfTaxation o = new ObjectOfTaxation();
            o.setAddress(src.optString("address"));
            o.setTitle(src.optString("title"));
            o.setTaxpayer(tp);
            dao.addObjectOfTaxation(o);
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
     * delete object of taxition by objectOftaxition_id
     * @param src
     * @return
     */
    public static synchronized JSONObject deleteObjectOfTaxitionById(long taxition_id) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            ObjectOfTaxation o = dao.getObjectOfTaxationById(taxition_id);
            dao.deleteObjectOfTaxation(o);
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
                temp.put("MSG",  "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }
}
