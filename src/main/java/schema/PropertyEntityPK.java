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
public class PropertyEntityPK implements Serializable {
    private int propertyId;
    private int taxpayerTaxpayerId;
    private int propertyTypePropertyTypeId;

    @Column(name = "Property_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Column(name = "Taxpayer_Taxpayer_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getTaxpayerTaxpayerId() {
        return taxpayerTaxpayerId;
    }

    public void setTaxpayerTaxpayerId(int taxpayerTaxpayerId) {
        this.taxpayerTaxpayerId = taxpayerTaxpayerId;
    }

    @Column(name = "Property Type_PropertyType_id", nullable = false, insertable = true, updatable = true)
    @Id
    public int getPropertyTypePropertyTypeId() {
        return propertyTypePropertyTypeId;
    }

    public void setPropertyTypePropertyTypeId(int propertyTypePropertyTypeId) {
        this.propertyTypePropertyTypeId = propertyTypePropertyTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PropertyEntityPK that = (PropertyEntityPK) o;

        if (propertyId != that.propertyId) return false;
        if (propertyTypePropertyTypeId != that.propertyTypePropertyTypeId) return false;
        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = propertyId;
        result = 31 * result + taxpayerTaxpayerId;
        result = 31 * result + propertyTypePropertyTypeId;
        return result;
    }
}
