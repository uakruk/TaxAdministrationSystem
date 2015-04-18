package restful.resources;

import dao.Factory;
import dao.LicenseDAO;
import dao.TaxpayerDAO;
import logic.License;
import logic.Taxpayer;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.codehaus.jettison.json.JSONException;

import java.sql.Date;
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
public abstract class LicenseRes {

    private static Factory factory = Factory.getInstance();
    private static LicenseDAO dao = factory.getLicenseDAO();
    private static LicenseDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getLicenseDAO() : dao;
        return dao;
    }

    public static JSONObject performAction(String action, long taxpayer_id,
                                           long license_id, JSONObject src) {
        return action.equals("change") ? updateLicenseById(license_id, src) :
                action.equals("add") ? addLicense(taxpayer_id, src) : getLicenseById(license_id);
    }

    /**
     * get licenses by taxpayer_id
     * @param
     * @return
     */
    public static JSONArray getAllLicensesById(long taxpayer_id) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            TaxpayerDAO tdao = factory.getTaxpayerDAO();
            Collection<License> col = tdao.getTaxpayerById(taxpayer_id)
                    .getLicenses();
            Iterator<License> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                License l = iter.next();
                temp.put("license_id", l.getLicense_id());
                temp.put("number", l.getNumber());
                temp.put("series", l.getSeries());
                temp.put("issueDate", l.getIssueDate().toString());
                temp.put("validityOf", l.getValidityOf().toString());
                temp.put("typeOfActivity", l.getTypeOfActivity());
                temp.put("authorityIssuedLicense", l.getAuthorityIssuedLicense());
                temp.put("numberOfDecisionAboutIssue", l.getNumberOfDecisionAboutIssue());
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
     * get license by license_id
     * @param src
     * @return
     */
    public static JSONObject getLicenseById(long license_id) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            License l = dao.getLicenseById(license_id);
            temp.put("license_id", l.getLicense_id());
            temp.put("series", l.getSeries());
            temp.put("number", l.getNumber());
            temp.put("issueDate", l.getIssueDate().toString());
            temp.put("validityOf", l.getValidityOf().toString());
            temp.put("typeOfActivity", l.getTypeOfActivity());
            temp.put("authorityIssuedLicense", l.getAuthorityIssuedLicense());
            temp.put("numberOfDecisionAboutIssue", l.getNumberOfDecisionAboutIssue());
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
     * update license by license_id
     * @param src
     * @return
     */
    public static synchronized JSONObject updateLicenseById(long license_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            License l = dao.getLicenseById(license_id);
            l.setAuthorityIssuedLicense(src.optString("authorityIssuedLicense"));
            l.setIssueDate(new Date(src.optLong("issueDate")));
            l.setNumber(src.optLong("number"));
            l.setNumberOfDecisionAboutIssue(src.optLong("numberOfDecisionAboutIssue"));
            l.setSeries(src.optString("series"));
            l.setTypeOfActivity(src.optString("typeOfActivity"));
            l.setValidityOf(new Date(src.optLong("validityOf")));
            dao.updateLicense(l);
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
     * add license by taxpayer_id
     * @param src
     * @return
     */
    public static synchronized JSONObject addLicense(long taxpayer_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Taxpayer tp = factory.getTaxpayerDAO().getTaxpayerById(taxpayer_id);
            License l = new License();
            l.setAuthorityIssuedLicense(src.optString("authorityIssuedLicense"));
            l.setIssueDate(new Date(src.optLong("issueDate")));
            l.setNumber(src.optLong("number"));
            l.setNumberOfDecisionAboutIssue(src.optLong("numberOfDecisionAboutIssue"));
            l.setSeries(src.optString("series"));
            l.setTypeOfActivity(src.optString("typeOfActivity"));
            l.setValidityOf(new Date(src.optLong("validityOf")));
            l.setTaxpayer(tp);
            dao.addLicense(l);
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
