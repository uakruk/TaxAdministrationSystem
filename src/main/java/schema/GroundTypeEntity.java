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
@Table(name = "GroundType", schema = "", catalog = "Podatkova")
public class GroundTypeEntity {
    private int groundTypeId;
    private String name;

    @Id
    @Column(name = "GroundType_id", nullable = false, insertable = true, updatable = true)
    public int getGroundTypeId() {
        return groundTypeId;
    }

    public void setGroundTypeId(int groundTypeId) {
        this.groundTypeId = groundTypeId;
    }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroundTypeEntity that = (GroundTypeEntity) o;

        if (groundTypeId != that.groundTypeId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = groundTypeId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
