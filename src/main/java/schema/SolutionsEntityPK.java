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
public class SolutionsEntityPK implements Serializable {
    private int solutionsId;

    @Column(name = "Solutions_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getSolutionsId() {
        return solutionsId;
    }

    public void setSolutionsId(int solutionsId) {
        this.solutionsId = solutionsId;
    }

    private int staffStaffId;

    @Column(name = "Staff_Staff_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getStaffStaffId() {
        return staffStaffId;
    }

    public void setStaffStaffId(int staffStaffId) {
        this.staffStaffId = staffStaffId;
    }

    private int assayAssayId;

    @Column(name = "Assay_Assay_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getAssayAssayId() {
        return assayAssayId;
    }

    public void setAssayAssayId(int assayAssayId) {
        this.assayAssayId = assayAssayId;
    }

    private int assayTaxpayerTaxpayerId;

    @Column(name = "Assay_Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    @Id
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

        SolutionsEntityPK that = (SolutionsEntityPK) o;

        if (assayAssayId != that.assayAssayId) return false;
        if (assayTaxpayerTaxpayerId != that.assayTaxpayerTaxpayerId) return false;
        if (solutionsId != that.solutionsId) return false;
        if (staffStaffId != that.staffStaffId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = solutionsId;
        result = 31 * result + staffStaffId;
        result = 31 * result + assayAssayId;
        result = 31 * result + assayTaxpayerTaxpayerId;
        return result;
    }
}
