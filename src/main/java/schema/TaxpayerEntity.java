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
@Table(name = "Taxpayer", schema = "", catalog = "Podatkova")
public class TaxpayerEntity {
    private int taxpayerId;
    private String name;
    private int idCode;

    @Id
    @Column(name = "Taxpayer_id", nullable = false, insertable = true, updatable = true)
    public int getTaxpayerId() {
        return taxpayerId;
    }

    public void setTaxpayerId(int taxpayerId) {
        this.taxpayerId = taxpayerId;
    }

    @Basic
    @Column(name = "Name", nullable = false, insertable = true, updatable = true, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "Id_code", nullable = false, insertable = true, updatable = true)
    public int getIdCode() {
        return idCode;
    }

    public void setIdCode(int idCode) {
        this.idCode = idCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TaxpayerEntity that = (TaxpayerEntity) o;

        if (idCode != that.idCode) return false;
        if (taxpayerId != that.taxpayerId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = taxpayerId;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idCode;
        return result;
    }
}
