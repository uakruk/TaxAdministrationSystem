package restful.resources;

import dao.AuditDAO;
import dao.Factory;
import dao.TaxpayerDAO;
import logic.Audit;
import logic.Taxpayer;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONArray;

import java.sql.SQLException;
import java.sql.Date;
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
public abstract class AuditRes {

    public static synchronized JSONObject performAction(String action, long audit_id, JSONObject src) {
        return action.equals("change") ? updateAuditByID(audit_id, src) : getAuditByID(audit_id);
    }

    public static JSONArray getAllAudit(long ID) {
        JSONArray resp = new JSONArray();
        JSONObject temp;
        try {
            Factory factory = Factory.getInstance();
            TaxpayerDAO dao = factory.getTaxpayerDAO();
            Collection<Audit> col = dao.getTaxpayerById(ID).getAudits();
            Iterator<Audit> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Audit tobj = iter.next();
                temp.put("audit_id", tobj.getAudit_id());
                temp.put("startDate", tobj.getStartDate().toString());
                temp.put("endDate", tobj.getEndDate().toString());
                temp.put("registrationNumber", tobj.getRegistrationNumber());
                temp.put("comment", tobj.getComment());
                temp.put("reason", tobj.getReason());
           //     temp.put("refferal", iter.next().getReferral());
                resp.put(temp);
            }
           JSONObject jt = new JSONObject();
            jt.put("MSG", "Items have been delivered successfully");
            jt.put("HTTP_CODE", "200");
            resp.put(jt);
        } catch (JSONException e) {
                e.printStackTrace();
                JSONObject jt = new JSONObject();
                try {
                    jt.put("MSG", "Error while attempting creating a JSON");
                    jt.put("HTTP_CODE", "500");
                } catch (JSONException n) {
                    n.printStackTrace();
                }
        } catch (SQLException a) {
            a.printStackTrace();
            JSONObject jt = new JSONObject();
            try {
                jt.put("MSG", "Error while attempting to execute SQL querry");
                jt.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return resp;
    }

    public static JSONObject getAuditByID(long audit_id) {
        JSONObject temp = new JSONObject();
        try {
            Factory factory = Factory.getInstance();
            AuditDAO dao = factory.getAuditDAO();
            Audit audit = dao.getAuditById(audit_id);
            temp.put("audit_id", audit.getAudit_id());
            temp.put("startDate", audit.getStartDate().toString());
            temp.put("endDate", audit.getEndDate().toString());
            temp.put("registrationNumber", audit.getRegistrationNumber());
            temp.put("comment", audit.getComment());
            temp.put("reason", audit.getReason());
        //    temp.put("refferal", audit.getReferral());
            temp.put("MSG", "Items have been delivered successfully");
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

    public static synchronized JSONObject updateAuditByID(long audit_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            Factory factory = Factory.getInstance();
            AuditDAO dao = factory.getAuditDAO();
            Audit audit = dao.getAuditById(audit_id);
            audit.setComment(src.optString("comment"));
            audit.setReason(src.optString("reason"));
            audit.setStartDate(new Date(src.optLong("startDate")));
            audit.setEndDate(new Date(src.optLong("endDate")));
            temp.put("MSG", "Items have been changed successfully");
            temp.put("HTTP_CODE", "200");

        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while attempting processing a JSON");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while attempting processing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }

    public static synchronized JSONObject addAudit(long ID, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            Factory factory = Factory.getInstance();
            TaxpayerDAO tdao = factory.getTaxpayerDAO();
            Taxpayer tp = tdao.getTaxpayerById(ID);
            AuditDAO dao = factory.getAuditDAO();
            Audit audit = new Audit();
            audit.setTaxpayer(tp);
            audit.setComment(src.optString("comment"));
            audit.setReason(src.optString("reason"));
            audit.setStartDate(new Date(src.optLong("startDate")));
            audit.setEndDate(new Date(src.optLong("endDate")));
            //  audit.setAudit_id(src.optLong("audit_id")); ??????
            temp.put("MSG", "Items have been changed successfully");
            temp.put("HTTP_CODE", "200");

        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while attempting processing a JSON");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while attempting processing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }
}
