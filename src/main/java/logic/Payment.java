package main.java.logic;

import javax.persistence.*;
import java.sql.Date;
/**
 * Created by Admon on 27.03.2015.
 */
@Entity
@Table(name="Payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payment_id;
    @Column(name = "receiptNumber")
    private long receiptNumber;
    @Column(name = "idTransaction")
    private long idTransaction;
    @Column(name = "paymentDate")
    private Date paymentDate;
    @Column(name = "amountOfPayment")
    private double amountOfPayment;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="tax_id")
    private Tax tax;

    public Long getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(Long payment_id) {
        this.payment_id = payment_id;
    }


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

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
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