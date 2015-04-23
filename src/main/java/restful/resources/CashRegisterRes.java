package restful.resources;

import logic.CashRegister;
import logic.ObjectOfTaxation;
import dao.CashRegisterDAO;
import dao.Factory;
import dao.ObjectOfTaxationDAO;
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
public abstract class CashRegisterRes {

    private static Factory factory = Factory.getInstance();
    private static CashRegisterDAO dao = factory.getCashRegisterDAO();
    private static CashRegisterDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getCashRegisterDAO() : dao;
        return dao;
    }

    /**
     * get cash registers with Object of tasition ID
     * @param src
     * @return
     */
    public static JSONArray getAllashRegistersById(long taxition_id) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            Factory factory = Factory.getInstance();
            CashRegisterDAO dao = factory.getCashRegisterDAO();
            ObjectOfTaxationDAO odao = factory.getObjectOfTaxationDAO();
            Collection<CashRegister> col = odao.getObjectOfTaxationById(taxition_id)
                                                                .getCashRegisters();
            Iterator<CashRegister> iter = col.iterator();
            while(iter.hasNext()) {
                temp = new JSONObject();
                CashRegister cr = iter.next();
                temp.put("cashRegister_id", cr.getCashRegister_id());
                temp.put("ID", cr.getID());
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
     * get cash register with cashRegister_id
     * @param src
     * @return
     */
    public static JSONObject getCashRegisterById(long cashRegister_id) {
        JSONObject temp = new JSONObject();
        try {
            CashRegisterDAO dao = getDao();
            CashRegister cr = dao.getCashRegisterById(cashRegister_id);
            temp.put("cashRegister_id", cr.getCashRegister_id());
            temp.put("ID", cr.getID());
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
     * update cash register with cashRegister_id
     * @param src
     * @return
     */
    public static synchronized JSONObject updateCashRegisterById(long cashRegister_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            CashRegisterDAO dao = getDao();
            CashRegister cr = dao.getCashRegisterById(cashRegister_id);
            cr.setID(src.optLong("ID"));
            dao.updateCashRegister(cr);
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
     * add cash register with objectOfTaxition_id
     * @param src
     * @return
     */
    public static synchronized JSONObject addCashRegister(long taxition_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            CashRegisterDAO dao = getDao();
            ObjectOfTaxationDAO tdao = factory.getObjectOfTaxationDAO();
            ObjectOfTaxation obj = tdao.getObjectOfTaxationById(taxition_id);
            CashRegister cr = new CashRegister();
            cr.setCashRegister_id(src.optLong("cashRegister_id"));
            cr.setID(src.optLong("ID"));
            cr.setObjectOfTaxation(obj);
            dao.addCashRegister(cr);
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
     * delete cash register with it's id
     * @param src
     * @return
     */
    public static synchronized JSONObject deleteCashRegisterById(long cashRegister_id) {
        JSONObject temp = new JSONObject();
        try {
            CashRegisterDAO dao = getDao();
            CashRegister cr = dao.getCashRegisterById(cashRegister_id);
            dao.deleteCashRegister(cr);
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
