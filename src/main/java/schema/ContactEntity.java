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
@Table(name = "Contact", schema = "", catalog = "Podatkova")
@IdClass(ContactEntityPK.class)
public class ContactEntity {
    private int contactId;
    private String value;
    private int taxpayerTaxpayerId;
    private int contactTypeContactTypeId;

    @Id
    @Column(name = "Contact_id", nullable = false, insertable = true, updatable = true)
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Basic
    @Column(name = "Value", nullable = false, insertable = true, updatable = true, length = 40)
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
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
    @Column(name = "Contact Type_ContactType_id", nullable = false, insertable = true, updatable = true)
    public int getContactTypeContactTypeId() {
        return contactTypeContactTypeId;
    }

    public void setContactTypeContactTypeId(int contactTypeContactTypeId) {
        this.contactTypeContactTypeId = contactTypeContactTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ContactEntity that = (ContactEntity) o;

        if (contactId != that.contactId) return false;
        if (contactTypeContactTypeId != that.contactTypeContactTypeId) return false;
        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;
        if (value != null ? !value.equals(that.value) : that.value != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        result = 31 * result + taxpayerTaxpayerId;
        result = 31 * result + contactTypeContactTypeId;
        return result;
    }
}
