package schema;

import javax.persistence.*;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 12.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
@Entity
@Table(name = "Payment", schema = "", catalog = "Podatkova")
@IdClass(PaymentEntityPK.class)
public class PaymentEntity {
    private int paymentId;
    private double suma;
    private String date;
    private int idTransaction;
    private int numCheck;
    private int taxesTaxesId;
    private int taxesTaxpayerTaxpayerId;

    @Id
    @Column(name = "Payment_id", nullable = false, insertable = true, updatable = true)
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Basic
    @Column(name = "Suma", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    @Basic
    @Column(name = "Date", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Basic
    @Column(name = "Id_transaction", nullable = false, insertable = true, updatable = true)
    public int getIdTransaction() {
        return idTransaction;
    }

    public void setIdTransaction(int idTransaction) {
        this.idTransaction = idTransaction;
    }

    @Basic
    @Column(name = "Num_check", nullable = false, insertable = true, updatable = true)
    public int getNumCheck() {
        return numCheck;
    }

    public void setNumCheck(int numCheck) {
        this.numCheck = numCheck;
    }

    @Id
    @Column(name = "Taxes_Taxes_id", nullable = false, insertable = true, updatable = true)
    public int getTaxesTaxesId() {
        return taxesTaxesId;
    }

    public void setTaxesTaxesId(int taxesTaxesId) {
        this.taxesTaxesId = taxesTaxesId;
    }

    @Id
    @Column(name = "Taxes_Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    public int getTaxesTaxpayerTaxpayerId() {
        return taxesTaxpayerTaxpayerId;
    }

    public void setTaxesTaxpayerTaxpayerId(int taxesTaxpayerTaxpayerId) {
        this.taxesTaxpayerTaxpayerId = taxesTaxpayerTaxpayerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaymentEntity that = (PaymentEntity) o;

        if (idTransaction != that.idTransaction) return false;
        if (numCheck != that.numCheck) return false;
        if (paymentId != that.paymentId) return false;
        if (Double.compare(that.suma, suma) != 0) return false;
        if (taxesTaxesId != that.taxesTaxesId) return false;
        if (taxesTaxpayerTaxpayerId != that.taxesTaxpayerTaxpayerId) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = paymentId;
        temp = Double.doubleToLongBits(suma);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + idTransaction;
        result = 31 * result + numCheck;
        result = 31 * result + taxesTaxesId;
        result = 31 * result + taxesTaxpayerTaxpayerId;
        return result;
    }
}
