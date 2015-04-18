package restful.resources;

import dao.Factory;
import dao.PaymentDAO;
import dao.TaxDAO;
import logic.Payment;
import logic.Tax;
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
public abstract class PaymentRes {
    private static Factory factory = Factory.getInstance();
    private static PaymentDAO dao = factory.getPaymentDAO();
    private static PaymentDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getPaymentDAO() : dao;
        return dao;
    }

    /**
     * get payments by tax_id
     * @param src
     * @return
     */
    public static JSONArray getAllPaymentsById(long tax_id) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            TaxDAO tdao= factory.getTaxDAO();
            Collection<Payment> col = tdao.getTaxById(tax_id)
                    .getPayments();
            Iterator<Payment> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Payment p = iter.next();
                temp.put("payment_id", p.getPayment_id());
                temp.put("amountOfPayment", p.getAmountOfPayment());
                temp.put("idTransaction", p.getIdTransaction());
                temp.put("paymentDate", p.getPaymentDate().toString());
                temp.put("receiptNumber", p.getReceiptNumber());
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
     * get payment by payment_id
     * @param src
     * @return
     */
    public static JSONObject getPaymentById(long payment_id) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Payment p = dao.getPaymentById(payment_id);
            temp.put("payment_id", p.getPayment_id());
            temp.put("amountOfPayment", p.getAmountOfPayment());
            temp.put("idTransaction", p.getIdTransaction());
            temp.put("paymentDate", p.getPaymentDate().toString());
            temp.put("receiptNumber", p.getReceiptNumber());
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
     * update payment by payment_id
     * @param src
     * @return
     */
    public static synchronized JSONObject updatePaymentById(long payment_id,
                                                            JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Payment p = dao.getPaymentById(payment_id);
            p.setAmountOfPayment(src.optDouble("amountOfPayment"));
            p.setIdTransaction(src.optLong("idTransaction"));
            p.setPaymentDate(new Date(src.optLong("paymentDate")));
            p.setReceiptNumber(src.optLong("receiptNumber"));
            dao.updatePayment(p);
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
     * add payment by tax_id
     * @param src
     * @return
     */
    public static synchronized JSONObject addPayment(long tax_id,
                                                     JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Tax t = factory.getTaxDAO().getTaxById(tax_id);
            Payment p = new Payment();
            p.setAmountOfPayment(src.optDouble("amountOfPayment"));
            p.setIdTransaction(src.optLong("idTransaction"));
            p.setPaymentDate(new Date(src.optLong("paymentDate")));
            p.setReceiptNumber(src.optLong("receiptNumber"));
            p.setTax(t);
            dao.addPayment(p);
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
