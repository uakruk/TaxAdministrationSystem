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
@Table(name = "Staff", schema = "", catalog = "Podatkova")
@IdClass(StaffEntityPK.class)
public class StaffEntity {
    private int staffId;
    private String name;
    private int unitUnitId;
    private String position;

    @Id
    @Column(name = "Staff_id", nullable = false, insertable = true, updatable = true)
    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Id
    @Column(name = "Unit_Unit_id", nullable = false, insertable = true, updatable = true)
    public int getUnitUnitId() {
        return unitUnitId;
    }

    public void setUnitUnitId(int unitUnitId) {
        this.unitUnitId = unitUnitId;
    }

    @Basic
    @Column(name = "position", nullable = false, insertable = true, updatable = true, length = 50)
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StaffEntity that = (StaffEntity) o;

        if (staffId != that.staffId) return false;
        if (unitUnitId != that.unitUnitId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (position != null ? !position.equals(that.position) : that.position != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = staffId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + unitUnitId;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        return result;
    }
}
