package schema;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 12.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public class PaymentEntityPK implements Serializable {
    private int paymentId;
    private int taxesTaxesId;
    private int taxesTaxpayerTaxpayerId;

    @Column(name = "Payment_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    @Column(name = "Taxes_Taxes_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTaxesTaxesId() {
        return taxesTaxesId;
    }

    public void setTaxesTaxesId(int taxesTaxesId) {
        this.taxesTaxesId = taxesTaxesId;
    }

    @Column(name = "Taxes_Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    @Id
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

        PaymentEntityPK that = (PaymentEntityPK) o;

        if (paymentId != that.paymentId) return false;
        if (taxesTaxesId != that.taxesTaxesId) return false;
        if (taxesTaxpayerTaxpayerId != that.taxesTaxpayerTaxpayerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = paymentId;
        result = 31 * result + taxesTaxesId;
        result = 31 * result + taxesTaxpayerTaxpayerId;
        return result;
    }
}
