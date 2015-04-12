package main.java.dao;

import main.java.logic.Payment;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface PaymentDAO {
    public void addPayment(Payment payment) throws SQLException;
    public void updatePayment(Payment payment) throws SQLException;
    public Payment getPaymentById(Long payment_id) throws SQLException;
    public Collection getAllPayment() throws SQLException;
    public void deletePayment(Payment payment) throws SQLException;
}
