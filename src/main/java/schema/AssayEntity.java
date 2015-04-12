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
@Table(name = "Assay", schema = "", catalog = "Podatkova")
@IdClass(AssayEntityPK.class)
public class AssayEntity {
    private int assayId;
    private String dateStart;
    private String dateEnd;
    private int registrationNum;
    private String commert;
    private int taxpayerTaxpayerId;
    private int groundTypeGroundTypeId;

    @Id
    @Column(name = "Assay_id", nullable = false, insertable = true, updatable = true)
    public int getAssayId() {
        return assayId;
    }

    public void setAssayId(int assayId) {
        this.assayId = assayId;
    }

    @Basic
    @Column(name = "Date_start", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    @Basic
    @Column(name = "Date_end", nullable = false, insertable = true, updatable = true, length = 20)
    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    @Basic
    @Column(name = "Registration_num", nullable = false, insertable = true, updatable = true)
    public int getRegistrationNum() {
        return registrationNum;
    }

    public void setRegistrationNum(int registrationNum) {
        this.registrationNum = registrationNum;
    }

    @Basic
    @Column(name = "Commert", nullable = false, insertable = true, updatable = true, length = 300)
    public String getCommert() {
        return commert;
    }

    public void setCommert(String commert) {
        this.commert = commert;
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
    @Column(name = "Ground Type_GroundType_id", nullable = false, insertable = true, updatable = true)
    public int getGroundTypeGroundTypeId() {
        return groundTypeGroundTypeId;
    }

    public void setGroundTypeGroundTypeId(int groundTypeGroundTypeId) {
        this.groundTypeGroundTypeId = groundTypeGroundTypeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssayEntity that = (AssayEntity) o;

        if (assayId != that.assayId) return false;
        if (groundTypeGroundTypeId != that.groundTypeGroundTypeId) return false;
        if (registrationNum != that.registrationNum) return false;
        if (taxpayerTaxpayerId != that.taxpayerTaxpayerId) return false;
        if (commert != null ? !commert.equals(that.commert) : that.commert != null) return false;
        if (dateEnd != null ? !dateEnd.equals(that.dateEnd) : that.dateEnd != null) return false;
        if (dateStart != null ? !dateStart.equals(that.dateStart) : that.dateStart != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = assayId;
        result = 31 * result + (dateStart != null ? dateStart.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + registrationNum;
        result = 31 * result + (commert != null ? commert.hashCode() : 0);
        result = 31 * result + taxpayerTaxpayerId;
        result = 31 * result + groundTypeGroundTypeId;
        return result;
    }
}
