package dao;

import logic.Payment;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface PaymentDAO {
<<<<<<< HEAD
    public void addPayment(Payment payment) throws SQLException;
    public void updatePayment(Payment payment) throws SQLException;
    public Payment getPaymentById(Long payment_id) throws SQLException;
=======
    public void addPayment(Payment payment ) throws SQLException;
    public void updatePayment(Payment payment ) throws SQLException;
    public Payment getPaymentById(Long  payment_id) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Collection getAllPayment() throws SQLException;
    public void deletePayment(Payment payment) throws SQLException;
}
