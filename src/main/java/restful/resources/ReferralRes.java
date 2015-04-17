package restful.resources;

import logic.Audit;
import logic.Decree;
import logic.Referral;
import logic.Employee;

import dao.AuditDAO;
import dao.Factory;
import dao.ReferralDAO;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

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
public class ReferralRes {
/* IT's not necessary to make this class. Let it be the same id as in audit_id

  */
    private static Factory factory = Factory.getInstance();
    private static ReferralDAO dao = factory.getReferralDAO();
    private static ReferralDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getReferralDAO() : dao;
        return dao;
    }

    /**
     * get referrals by decree_id
     * @param src
     * @return
     */
    public JSONArray getReferralsByDecreeId(JSONObject src) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            Decree d = factory.getDecreeDAO().getDecreeById(src.optLong("decree_id"));
            Collection<Referral> col = d.getReferrals();
            Iterator<Referral> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Referral r = iter.next();
                temp.put("referral_id", r.getReferral_id());
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
     * get referrals by audit_id
     * @param src
     * @return
     */
    public JSONArray getReferralsByAuditId(JSONObject src) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            Audit a = factory.getAuditDAO().getAuditById(src.optLong("audit_id"));
            Collection<Referral> col = a.getReferrals();
            Iterator<Referral> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Referral r = iter.next();
                temp.put("referral_id", r.getReferral_id());
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
     * get referrals by employee_id
     * @param src
     * @return
     */
    public JSONArray getReferralsByEmployeeId(JSONObject src) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            Employee e = factory.getEmployeeDAO().getEmployeeById(src.optLong("employee_id"));
            Collection<Referral> col = e.getReferral();
            Iterator<Referral> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Referral r = iter.next();
                temp.put("referral_id", r.getReferral_id());
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
     * get referral by referral_id
     * @param src
     * @return
     */
    public JSONObject getReferralyById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Referral r = dao.getById(src.optLong("referral_id"));
            temp.put("referral_id", r.getReferral_id());
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
     * update referral by referral_id
     * @param src
     * @return
     */
    public JSONObject updateReferralById(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Referral r = dao.getById(src.optLong("referral_id"));
        /*    Employee e = r.getEmployee();
            Decree d = r.getDecree();
            Audit a = r.getAudit(); */
            dao.updateReferral(r);
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
     * add referral by employee_id, audit_id, decree_id
     * @param src
     * @return
     */
    public JSONObject addReferral(JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Employee e = factory.getEmployeeDAO().getEmployeeById(src.optLong("employee_id"));
            Audit a = factory.getAuditDAO().getAuditById(src.optLong("audit_id"));
            Decree d = factory.getDecreeDAO().getDecreeById(src.optLong("decree_id"));
            Referral r = new Referral();
            r.setAudit(a);
            r.setDecree(d);
            r.setEmployee(e);
            dao.addReferral(r);
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
