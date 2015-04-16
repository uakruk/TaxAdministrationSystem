package restful.resources;

import dao.Factory;
import dao.PropertyDAO;
import dao.TaxpayerDAO;
import logic.Property;
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
 * @author Yaroslav Kruk on 15.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public class PropertyRes {

    private static Factory factory = Factory.getInstance();
    private static PropertyDAO dao = factory.getPropertyDAO();
    private static PropertyDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getPropertyDAO() : dao;
        return dao;
    }

    /**
     * get property info by taxpayer_id
     * @param src
     * @return
     */
    public JSONArray getAllPropertyById(JSONObject src) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            TaxpayerDAO tdao = factory.getTaxpayerDAO();
            Collection<Property> col = tdao.getTaxpayerById(src.optLong("taxpayer_id"))
                    .getPropertys();
            Iterator<Property> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Property p = iter.next();
                temp.put("property_id", p.getProperty_id());
                temp.put("cadastralNumber", p.getCadastralNumber());
                temp.put("address", p.getAddress());
                temp.put("price", p.getPrice());
                temp.put("square", p.getSquare());
                temp.put("typeOfProperty", p.getTypeOfProperty());
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
     * get property by property_id
     * @param src
     * @return
     */
    public JSONObject getPropertyById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Property p = dao.getPropertyById(src.optLong("property_id"));
            temp.put("property_id", p.getProperty_id());
            temp.put("cadastralNumber", p.getCadastralNumber());
            temp.put("address", p.getAddress());
            temp.put("price", p.getPrice());
            temp.put("square", p.getSquare());
            temp.put("typeOfProperty", p.getTypeOfProperty());
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
     * update property by property_id
     * @param src
     * @return
     */
    public JSONObject updatePropertyById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Property p = dao.getPropertyById(src.optLong("property_id"));
            p.setCadastralNumber(src.optLong("cadastralNumber"));
            p.setAddress(src.optString("address"));
            p.setPrice(src.optDouble("price"));
            p.setSquare(src.optDouble("square"));
            p.setTypeOfProperty(src.optString("typeOfProperty"));
            dao.updateProperty(p);
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
     * add property by taxpayer_id
     * @param src
     * @return
     */
    public JSONObject addProperty(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Taxpayer tp = factory.getTaxpayerDAO().getTaxpayerById(src.optLong("taxpayer_id"));
            Property p = new Property();
            p.setCadastralNumber(src.optLong("cadastralNumber"));
            p.setAddress(src.optString("address"));
            p.setPrice(src.optDouble("price"));
            p.setSquare(src.optDouble("square"));
            p.setTypeOfProperty(src.optString("typeOfProperty"));
            p.setTaxpayer(tp);
            dao.addProperty(p);
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
     * delete property by property_id
     * @param src
     * @return
     */
    public JSONObject deletePropertyById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Property p = dao.getPropertyById(src.optLong("property_id"));
            dao.deleteProperty(p);
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
