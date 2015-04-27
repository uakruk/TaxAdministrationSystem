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
public class TaxesEntityPK implements Serializable {
    private int taxesId;
    private int taxpayerTaxpayerId;
    private int typeTaxesTypeTexesId;

    @Column(name = "Taxes_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTaxesId() {
        return taxesId;
    }

    public void setTaxesId(int taxesId) {
        this.taxesId = taxesId;
    }

    @Column(name = "Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTaxpayerTaxpayerId() {
        return taxpayerTaxpayerId;
    }

    public void setTaxpayerTaxpayerId(int taxpayerTaxpayerId) {
        this.taxpayerTaxpayerId = taxpayerTaxpayerId;
    }

    @Column(name = "Type taxes_Type_Texes_Id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTypeTaxesTypeTexesId() {
        return typeTaxesTypeTexesId;
    }

    public void setTypeTaxesTypeTexesId(int typeTaxesTypeTexesId) {
        this.typeTaxesTypeTexesId = typeTaxesTypeTexesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxesEntityPK that = (TaxesEntityPK) o;

        if (taxesId != that.taxesId) return false;
        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;
        if (typeTaxesTypeTexesId != that.typeTaxesTypeTexesId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taxesId;
        result = 31 * result + taxpayerTaxpayerId;
        result = 31 * result + typeTaxesTypeTexesId;
        return result;
    }
}
