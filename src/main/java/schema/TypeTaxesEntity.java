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
@Table(name = "TypeTaxes", schema = "", catalog = "Podatkova")
public class TypeTaxesEntity {
    private int typeTexesId;
    private String name;

    @Id
    @Column(name = "Type_Texes_Id", nullable = false, insertable = true, updatable = true)
    public int getTypeTexesId() {
        return typeTexesId;
    }

    public void setTypeTexesId(int typeTexesId) {
        this.typeTexesId = typeTexesId;
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

        TypeTaxesEntity that = (TypeTaxesEntity) o;

        if (typeTexesId != that.typeTexesId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = typeTexesId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
