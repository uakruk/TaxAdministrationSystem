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
public class ChargesEntityPK implements Serializable {
    private int chargesId;

    @Column(name = "Charges_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getChargesId() {
        return chargesId;
    }

    public void setChargesId(int chargesId) {
        this.chargesId = chargesId;
    }

    private int taxesTaxesId;

    @Column(name = "Taxes_Taxes_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTaxesTaxesId() {
        return taxesTaxesId;
    }

    public void setTaxesTaxesId(int taxesTaxesId) {
        this.taxesTaxesId = taxesTaxesId;
    }

    private int taxesTaxpayerTaxpayerId;

    @Column(name = "Taxes_Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTaxesTaxpayerTaxpayerId() {
        return taxesTaxpayerTaxpayerId;
    }

    public void setTaxesTaxpayerTaxpayerId(int taxesTaxpayerTaxpayerId) {
        this.taxesTaxpayerTaxpayerId = taxesTaxpayerTaxpayerId;
    }

    private int taxesTypeTaxesTypeTexesId;

    @Column(name = "Taxes_Type taxes_Type_Texes_Id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTaxesTypeTaxesTypeTexesId() {
        return taxesTypeTaxesTypeTexesId;
    }

    public void setTaxesTypeTaxesTypeTexesId(int taxesTypeTaxesTypeTexesId) {
        this.taxesTypeTaxesTypeTexesId = taxesTypeTaxesTypeTexesId;
    }

    private int paymentTypePaymentType;

    @Column(name = "PaymentType_PaymentType_", nullable = false, insertable = true, updatable = true)
    @Id
    public int getPaymentTypePaymentType() {
        return paymentTypePaymentType;
    }

    public void setPaymentTypePaymentType(int paymentTypePaymentType) {
        this.paymentTypePaymentType = paymentTypePaymentType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChargesEntityPK that = (ChargesEntityPK) o;

        if (chargesId != that.chargesId) return false;
        if (paymentTypePaymentType != that.paymentTypePaymentType) return false;
        if (taxesTaxesId != that.taxesTaxesId) return false;
        if (taxesTaxpayerTaxpayerId != that.taxesTaxpayerTaxpayerId) return false;
        if (taxesTypeTaxesTypeTexesId != that.taxesTypeTaxesTypeTexesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chargesId;
        result = 31 * result + taxesTaxesId;
        result = 31 * result + taxesTaxpayerTaxpayerId;
        result = 31 * result + taxesTypeTaxesTypeTexesId;
        result = 31 * result + paymentTypePaymentType;
        return result;
    }
}
