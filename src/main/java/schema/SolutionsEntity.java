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
@Table(name = "Solutions", schema = "", catalog = "Podatkova")
@IdClass(SolutionsEntityPK.class)
public class SolutionsEntity {
    private int solutionsId;
    private String text;
    private byte chiefAgreement;
    private int staffStaffId;
    private int assayAssayId;
    private int assayTaxpayerTaxpayerId;

    @Id
    @Column(name = "Solutions_id", nullable = false, insertable = true, updatable = true)
    public int getSolutionsId() {
        return solutionsId;
    }

    public void setSolutionsId(int solutionsId) {
        this.solutionsId = solutionsId;
    }

    @Basic
    @Column(name = "Text", nullable = false, insertable = true, updatable = true, length = 300)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "Chief_Agreement", nullable = false, insertable = true, updatable = true)
    public byte getChiefAgreement() {
        return chiefAgreement;
    }

    public void setChiefAgreement(byte chiefAgreement) {
        this.chiefAgreement = chiefAgreement;
    }

    @Id
    @Column(name = "Staff_Staff_id", nullable = false, insertable = true, updatable = true)
    public int getStaffStaffId() {
        return staffStaffId;
    }

    public void setStaffStaffId(int staffStaffId) {
        this.staffStaffId = staffStaffId;
    }

    @Id
    @Column(name = "Assay_Assay_id", nullable = false, insertable = true, updatable = true)
    public int getAssayAssayId() {
        return assayAssayId;
    }

    public void setAssayAssayId(int assayAssayId) {
        this.assayAssayId = assayAssayId;
    }

    @Id
    @Column(name = "Assay_Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    public int getAssayTaxpayerTaxpayerId() {
        return assayTaxpayerTaxpayerId;
    }

    public void setAssayTaxpayerTaxpayerId(int assayTaxpayerTaxpayerId) {
        this.assayTaxpayerTaxpayerId = assayTaxpayerTaxpayerId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SolutionsEntity that = (SolutionsEntity) o;

        if (assayAssayId != that.assayAssayId) return false;
        if (assayTaxpayerTaxpayerId != that.assayTaxpayerTaxpayerId) return false;
        if (chiefAgreement != that.chiefAgreement) return false;
        if (solutionsId != that.solutionsId) return false;
        if (staffStaffId != that.staffStaffId) return false;
        if (text != null ? !text.equals(that.text) : that.text != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = solutionsId;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (int) chiefAgreement;
        result = 31 * result + staffStaffId;
        result = 31 * result + assayAssayId;
        result = 31 * result + assayTaxpayerTaxpayerId;
        return result;
    }
}
