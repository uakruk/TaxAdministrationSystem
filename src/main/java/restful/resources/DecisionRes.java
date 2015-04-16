package restful.resources;

import dao.AuditDAO;
import dao.DecisionDAO;
import dao.EmployeeDAO;
import dao.Factory;
import logic.Audit;
import logic.Decision;
import logic.Employee;
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
public class DecisionRes {
    /*go back to the future*/
    private static Factory factory = Factory.getInstance();
    private static DecisionDAO dao = factory.getDecisionDAO();
    private static DecisionDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getDecisionDAO() : dao;
        return dao;
    }

    /**
     * get get decisions by audit_id
     * @param src
     * @return
     */
    public JSONArray getDecisionsByAuditId(JSONObject src) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            AuditDAO adao = factory.getAuditDAO();
            Collection<Decision> col = adao.getAuditById(src.optLong("audit_id")).getDecisions();
            Iterator<Decision> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Decision d = iter.next();
                temp.put("decision_id", d.getDecision_id());
                temp.put("chief", d.getChief());
                temp.put("signature", d.getSignature());
                temp.put("text", d.getText());
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
     * get get decisions by employee_id
     * @param src
     * @return
     */
    public JSONArray getDecisionsByEmployeeId(JSONObject src) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            EmployeeDAO edao = factory.getEmployeeDAO();
            Collection<Decision> col = edao.getEmployeeById(src.optLong("employee_id")).getDecisions();
            Iterator<Decision> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Decision d = iter.next();
                temp.put("decision_id", d.getDecision_id());
                temp.put("chief", d.getChief());
                temp.put("signature", d.getSignature());
                temp.put("text", d.getText());
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
     * get decision by decision_id
     * @param src
     * @return
     */
    public JSONObject getDecisionById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Decision d = dao.getDecisionById(src.optLong("decision_id"));
            temp.put("decision_id", d.getDecision_id());
            temp.put("chief", d.getChief());
            temp.put("signature", d.getSignature());
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
     * update decision by decision_id
     * @param src
     * @return
     */
    public JSONObject updateDecisionById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Decision d = dao.getDecisionById(src.optLong("decision_id"));
            d.setChief(src.optString("chief"));
            d.setSignature(src.optString("signature"));
            d.setText(src.optString("text"));
            dao.updateDecision(d);
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
     * add decision by audit_id & employee_id
     * @param src
     * @return
     */
    public JSONObject addDecision(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Audit a = factory.getAuditDAO().getAuditById(src.optLong("audit_id"));
            Employee e = factory.getEmployeeDAO().getEmployeeById(src.optLong("employee_id"));
            Decision d = new Decision();
            d.setChief(src.optString("chief"));
            d.setSignature(src.optString("signature"));
            d.setText(src.optString("text"));
            d.setEmployee(e);
            d.setAudit(a);
            dao.addDecision(d);
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
