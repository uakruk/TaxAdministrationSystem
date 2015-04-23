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
@Table(name = "Taxes", schema = "", catalog = "Podatkova")
@IdClass(TaxesEntityPK.class)
public class TaxesEntity {
    private int taxesId;
    private String begining;
    private String end;
    private int taxpayerTaxpayerId;
    private int typeTaxesTypeTexesId;

    @Id
    @Column(name = "Taxes_id", nullable = false, insertable = true, updatable = true)
    public int getTaxesId() {
        return taxesId;
    }

    public void setTaxesId(int taxesId) {
        this.taxesId = taxesId;
    }

    @Basic
    @Column(name = "Begining", nullable = false, insertable = true, updatable = true, length = 20)
    public String getBegining() {
        return begining;
    }

    public void setBegining(String begining) {
        this.begining = begining;
    }

    @Basic
    @Column(name = "End", nullable = false, insertable = true, updatable = true, length = 20)
    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    @Id
    @Column(name = "Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    public int getTaxpayerTaxpayerId() {
        return taxpayerTaxpayerId;
    }

    public void setTaxpayerTaxpayerId(int taxpayerTaxpayerId) {
        this.taxpayerTaxpayerId = taxpayerTaxpayerId;
    }

    @Id
    @Column(name = "Type taxes_Type_Texes_Id", nullable = false, insertable = true, updatable = true)
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

        TaxesEntity that = (TaxesEntity) o;

        if (taxesId != that.taxesId) return false;
        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;
        if (typeTaxesTypeTexesId != that.typeTaxesTypeTexesId) return false;
        if (begining != null ? !begining.equals(that.begining) : that.begining != null) return false;
        if (end != null ? !end.equals(that.end) : that.end != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taxesId;
        result = 31 * result + (begining != null ? begining.hashCode() : 0);
        result = 31 * result + (end != null ? end.hashCode() : 0);
        result = 31 * result + taxpayerTaxpayerId;
        result = 31 * result + typeTaxesTypeTexesId;
        return result;
    }
}
