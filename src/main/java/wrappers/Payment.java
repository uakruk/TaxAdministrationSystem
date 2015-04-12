package wrappers;

import java.sql.Date;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Payment {

    private long receiptNumber;
    private long idTransaction;
    private Date paymentDate;
    private double amountOfPayment;

    public long getReceiptNumber() {
        return receiptNumber;
    }

    public void setReceiptNumber(long receiptNumber) {
        this.receiptNumber = receiptNumber;
    }

    public long getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(long idTransaction) {
        this.idTransaction = idTransaction;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmountOfPayment() {
        return amountOfPayment;
    }

    public void setAmountOfPayment(double amountOfPayment) {
        this.amountOfPayment = amountOfPayment;
    }

    public Payment() {
        receiptNumber = 0;
        idTransaction = 0;
        paymentDate = new Date(0);
        amountOfPayment = 0;
    }

    public Payment(long receiptNumber, long idTransaction, Date paymentDate, double amountOfPayment) {
        this.receiptNumber = receiptNumber;
        this.idTransaction = idTransaction;
        this.paymentDate = paymentDate;
        this.amountOfPayment = amountOfPayment;
    }
}
