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
public class AssayEntityPK implements Serializable {
    private int assayId;
    private int taxpayerTaxpayerId;
    private int groundTypeGroundTypeId;

    @Column(name = "Assay_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getAssayId() {
        return assayId;
    }

    public void setAssayId(int assayId) {
        this.assayId = assayId;
    }

    @Column(name = "Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTaxpayerTaxpayerId() {
        return taxpayerTaxpayerId;
    }

    public void setTaxpayerTaxpayerId(int taxpayerTaxpayerId) {
        this.taxpayerTaxpayerId = taxpayerTaxpayerId;
    }

    @Column(name = "Ground Type_GroundType_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getGroundTypeGroundTypeId() {
        return groundTypeGroundTypeId;
    }

    public void setGroundTypeGroundTypeId(int groundTypeGroundTypeId) {
        this.groundTypeGroundTypeId = groundTypeGroundTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssayEntityPK that = (AssayEntityPK) o;

        if (assayId != that.assayId) return false;
        if (groundTypeGroundTypeId != that.groundTypeGroundTypeId) return false;
        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assayId;
        result = 31 * result + taxpayerTaxpayerId;
        result = 31 * result + groundTypeGroundTypeId;
        return result;
    }
}
