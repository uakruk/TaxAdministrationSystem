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
@Table(name = "Direction", schema = "", catalog = "Podatkova")
@IdClass(DirectionEntityPK.class)
public class DirectionEntity {
    private int directionId;
    private int orderOrderId;
    private int staffStaffId;
    private int assayAssayId;
    private int assayTaxpayerTaxpayerId;

    @Id
    @Column(name = "Direction_id", nullable = false, insertable = true, updatable = true)
    public int getDirectionId() {
        return directionId;
    }

    public void setDirectionId(int directionId) {
        this.directionId = directionId;
    }

    @Id
    @Column(name = "Order_Order_id", nullable = false, insertable = true, updatable = true)
    public int getOrderOrderId() {
        return orderOrderId;
    }

    public void setOrderOrderId(int orderOrderId) {
        this.orderOrderId = orderOrderId;
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

        DirectionEntity that = (DirectionEntity) o;

        if (assayAssayId != that.assayAssayId) return false;
        if (assayTaxpayerTaxpayerId != that.assayTaxpayerTaxpayerId) return false;
        if (directionId != that.directionId) return false;
        if (orderOrderId != that.orderOrderId) return false;
        if (staffStaffId != that.staffStaffId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = directionId;
        result = 31 * result + orderOrderId;
        result = 31 * result + staffStaffId;
        result = 31 * result + assayAssayId;
        result = 31 * result + assayTaxpayerTaxpayerId;
        return result;
    }
}
