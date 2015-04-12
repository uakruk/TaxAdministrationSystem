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
public class ContactEntityPK implements Serializable {
    private int contactId;
    private int taxpayerTaxpayerId;
    private int contactTypeContactTypeId;

    @Column(name = "Contact_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getContactId() {
        return contactId;
    }

    public void setContactId(int contactId) {
        this.contactId = contactId;
    }

    @Column(name = "Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTaxpayerTaxpayerId() {
        return taxpayerTaxpayerId;
    }

    public void setTaxpayerTaxpayerId(int taxpayerTaxpayerId) {
        this.taxpayerTaxpayerId = taxpayerTaxpayerId;
    }

    @Column(name = "Contact Type_ContactType_id", nullable = false, insertable = true, updatable = true)
    @Id
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

        ContactEntityPK that = (ContactEntityPK) o;

        if (contactId != that.contactId) return false;
        if (contactTypeContactTypeId != that.contactTypeContactTypeId) return false;
        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = contactId;
        result = 31 * result + taxpayerTaxpayerId;
        result = 31 * result + contactTypeContactTypeId;
        return result;
    }
}
