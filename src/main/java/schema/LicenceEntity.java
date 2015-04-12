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
@Table(name = "Licence", schema = "", catalog = "Podatkova")
public class LicenceEntity {
    private int licenceId;
    private String serialNumNum;
    private String issueDate;
    private String expirationDate;
    private int decisionNum;
    private String licenseState;
    private String activity;

    @Id
    @Column(name = "Licence_id", nullable = false, insertable = true, updatable = true)
    public int getLicenceId() {
        return licenceId;
    }

    public void setLicenceId(int licenceId) {
        this.licenceId = licenceId;
    }

    @Basic
    @Column(name = "SerialNum_num", nullable = false, insertable = true, updatable = true, length = 20)
    public String getSerialNumNum() {
        return serialNumNum;
    }

    public void setSerialNumNum(String serialNumNum) {
        this.serialNumNum = serialNumNum;
    }

    @Basic
    @Column(name = "Issue_date", nullable = false, insertable = true, updatable = true, length = 20)
    public String getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    @Basic
    @Column(name = "Expiration_date", nullable = false, insertable = true, updatable = true, length = 20)
    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Basic
    @Column(name = "Decision_num", nullable = false, insertable = true, updatable = true)
    public int getDecisionNum() {
        return decisionNum;
    }

    public void setDecisionNum(int decisionNum) {
        this.decisionNum = decisionNum;
    }

    @Basic
    @Column(name = "LicenseState", nullable = false, insertable = true, updatable = true, length = 50)
    public String getLicenseState() {
        return licenseState;
    }

    public void setLicenseState(String licenseState) {
        this.licenseState = licenseState;
    }

    @Basic
    @Column(name = "Activity", nullable = false, insertable = true, updatable = true, length = 50)
    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LicenceEntity that = (LicenceEntity) o;

        if (decisionNum != that.decisionNum) return false;
        if (licenceId != that.licenceId) return false;
        if (activity != null ? !activity.equals(that.activity) : that.activity != null) return false;
        if (expirationDate != null ? !expirationDate.equals(that.expirationDate) : that.expirationDate != null)
            return false;
        if (issueDate != null ? !issueDate.equals(that.issueDate) : that.issueDate != null) return false;
        if (licenseState != null ? !licenseState.equals(that.licenseState) : that.licenseState != null) return false;
        if (serialNumNum != null ? !serialNumNum.equals(that.serialNumNum) : that.serialNumNum != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = licenceId;
        result = 31 * result + (serialNumNum != null ? serialNumNum.hashCode() : 0);
        result = 31 * result + (issueDate != null ? issueDate.hashCode() : 0);
        result = 31 * result + (expirationDate != null ? expirationDate.hashCode() : 0);
        result = 31 * result + decisionNum;
        result = 31 * result + (licenseState != null ? licenseState.hashCode() : 0);
        result = 31 * result + (activity != null ? activity.hashCode() : 0);
        return result;
    }
}
