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
@Table(name = "Charges", schema = "", catalog = "Podatkova")
@IdClass(ChargesEntityPK.class)
public class ChargesEntity {
    private int chargesId;
    private String maturity;
    private String dateOfAccrual;
    private int suma;
    private int taxesTaxesId;
    private int taxesTaxpayerTaxpayerId;
    private int taxesTypeTaxesTypeTexesId;
    private int paymentTypePaymentType;

    @Id
    @Column(name = "Charges_id", nullable = false, insertable = true, updatable = true)
    public int getChargesId() {
        return chargesId;
    }

    public void setChargesId(int chargesId) {
        this.chargesId = chargesId;
    }

    @Basic
    @Column(name = "Maturity", nullable = false, insertable = true, updatable = true, length = 20)
    public String getMaturity() {
        return maturity;
    }

    public void setMaturity(String maturity) {
        this.maturity = maturity;
    }

    @Basic
    @Column(name = "Date_of_accrual", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDateOfAccrual() {
        return dateOfAccrual;
    }

    public void setDateOfAccrual(String dateOfAccrual) {
        this.dateOfAccrual = dateOfAccrual;
    }

    @Basic
    @Column(name = "Suma", nullable = false, insertable = true, updatable = true)
    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
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

    @Id
    @Column(name = "Taxes_Type taxes_Type_Texes_Id", nullable = false, insertable = true, updatable = true)
    public int getTaxesTypeTaxesTypeTexesId() {
        return taxesTypeTaxesTypeTexesId;
    }

    public void setTaxesTypeTaxesTypeTexesId(int taxesTypeTaxesTypeTexesId) {
        this.taxesTypeTaxesTypeTexesId = taxesTypeTaxesTypeTexesId;
    }

    @Id
    @Column(name = "PaymentType_PaymentType_", nullable = false, insertable = true, updatable = true)
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

        ChargesEntity that = (ChargesEntity) o;

        if (chargesId != that.chargesId) return false;
        if (paymentTypePaymentType != that.paymentTypePaymentType) return false;
        if (suma != that.suma) return false;
        if (taxesTaxesId != that.taxesTaxesId) return false;
        if (taxesTaxpayerTaxpayerId != that.taxesTaxpayerTaxpayerId) return false;
        if (taxesTypeTaxesTypeTexesId != that.taxesTypeTaxesTypeTexesId) return false;
        if (dateOfAccrual != null ? !dateOfAccrual.equals(that.dateOfAccrual) : that.dateOfAccrual != null)
            return false;
        if (maturity != null ? !maturity.equals(that.maturity) : that.maturity != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = chargesId;
        result = 31 * result + (maturity != null ? maturity.hashCode() : 0);
        result = 31 * result + (dateOfAccrual != null ? dateOfAccrual.hashCode() : 0);
        result = 31 * result + suma;
        result = 31 * result + taxesTaxesId;
        result = 31 * result + taxesTaxpayerTaxpayerId;
        result = 31 * result + taxesTypeTaxesTypeTexesId;
        result = 31 * result + paymentTypePaymentType;
        return result;
    }
}
