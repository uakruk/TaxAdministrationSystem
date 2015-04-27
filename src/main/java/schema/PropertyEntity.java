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
@Table(name = "Property", schema = "", catalog = "Podatkova")
@IdClass(PropertyEntityPK.class)
public class PropertyEntity {
    private int propertyId;
    private String adress;
    private double squere;
    private int cadastralNumber;
    private double cost;
    private int taxpayerTaxpayerId;
    private int propertyTypePropertyTypeId;

    @Id
    @Column(name = "Property_id", nullable = false, insertable = true, updatable = true)
    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    @Basic
    @Column(name = "Adress", nullable = false, insertable = true, updatable = true, length = 70)
    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Basic
    @Column(name = "Squere", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getSquere() {
        return squere;
    }

    public void setSquere(double squere) {
        this.squere = squere;
    }

    @Basic
    @Column(name = "Cadastral_number", nullable = false, insertable = true, updatable = true)
    public int getCadastralNumber() {
        return cadastralNumber;
    }

    public void setCadastralNumber(int cadastralNumber) {
        this.cadastralNumber = cadastralNumber;
    }

    @Basic
    @Column(name = "Cost", nullable = false, insertable = true, updatable = true, precision = 0)
    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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
    @Column(name = "Property Type_PropertyType_id", nullable = false, insertable = true, updatable = true)
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

        PropertyEntity that = (PropertyEntity) o;

        if (cadastralNumber != that.cadastralNumber) return false;
        if (Double.compare(that.cost, cost) != 0) return false;
        if (propertyId != that.propertyId) return false;
        if (propertyTypePropertyTypeId != that.propertyTypePropertyTypeId) return false;
        if (Double.compare(that.squere, squere) != 0) return false;
        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;
        if (adress != null ? !adress.equals(that.adress) : that.adress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = propertyId;
        result = 31 * result + (adress != null ? adress.hashCode() : 0);
        temp = Double.doubleToLongBits(squere);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + cadastralNumber;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + taxpayerTaxpayerId;
        result = 31 * result + propertyTypePropertyTypeId;
        return result;
    }
}
