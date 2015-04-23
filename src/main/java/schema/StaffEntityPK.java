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
public class StaffEntityPK implements Serializable {
    private int staffId;
    private int unitUnitId;

    @Column(name = "Staff_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Column(name = "Unit_Unit_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getUnitUnitId() {
        return unitUnitId;
    }

    public void setUnitUnitId(int unitUnitId) {
        this.unitUnitId = unitUnitId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffEntityPK that = (StaffEntityPK) o;

        if (staffId != that.staffId) return false;
        if (unitUnitId != that.unitUnitId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + unitUnitId;
        return result;
    }
}
