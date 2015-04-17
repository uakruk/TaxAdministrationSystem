package restful.resources;

import dao.ContactDAO;
import dao.Factory;
import dao.TaxpayerDAO;
import logic.Contact;
import logic.Taxpayer;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONArray;

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
public abstract class ContactRes {

    private static Factory factory = Factory.getInstance();
    private static ContactDAO dao = factory.getContactDAO();
    private static ContactDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getContactDAO() : dao;
        return dao;
    }

    /**
     * get contacts by taxpayer_id
     * @param ID
     * @return
     */
    public static JSONArray getAllContactsById(long ID) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            TaxpayerDAO tdao = factory.getTaxpayerDAO();
            Collection<Contact> col = tdao.getTaxpayerById(ID)
                    .getContacts();
            Iterator<Contact> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Contact c = iter.next();
                temp.put("contact_id", c.getContact_id());
                temp.put("value", c.getValue());
                temp.put("typeOfContact", c.getTypeOfContact());
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
     * get contact by contact_id
     * @param contact_id
     * @return
     */
    public static JSONObject getContactById(long contact_id) {
        JSONObject temp = new JSONObject();
        try {
            ContactDAO dao = getDao();
            Contact c = dao.getContactById(contact_id);
            temp.put("contact_id", c.getContact_id());
            temp.put("value", c.getValue());
            temp.put("typeOfContact", c.getTypeOfContact());
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
     * update contact by contacct_id
     * @param src
     * @return
     */
    public static synchronized JSONObject updateContactById(long contact_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            ContactDAO dao = getDao();
            Contact c = dao.getContactById(contact_id);
            c.setValue(src.optString("value"));
            c.setTypeOfContact(src.optString("typeOfContact"));
            dao.updateContact(c);
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
     * add contact by taxpayer_id
     * @param src
     * @param ID
     * @return
     */
    public JSONObject addContact(long ID, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            ContactDAO dao = getDao();
            Taxpayer tp = factory.getTaxpayerDAO().getTaxpayerById(ID);
            Contact c = new Contact();
            c.setValue(src.optString("value"));
            c.setTypeOfContact(src.optString("typeOfContact"));
            c.setTaxpayer(tp);
            dao.addContact(c);
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
     * delete contact by contact_id
     * @param contact_id
     * @return
     */
    public JSONObject deleteContacById(long contact_id) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Contact c = dao.getContactById(contact_id);
            dao.deleteContact(c);
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
