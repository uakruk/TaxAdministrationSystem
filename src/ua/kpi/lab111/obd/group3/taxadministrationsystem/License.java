package ua.kpi.lab111.obd.group3.taxadministrationsystem;

import java.sql.Date;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class License {

    private String series;
    private long number;
    private Date issueDate;
    private Date validityOf;
    private String typeOfActivity;
    private String authorityIssuedLicense;
    private long numberOfDecisionAboutIssue;

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getValidityOf() {
        return validityOf;
    }

    public void setValidityOf(Date validityOf) {
        this.validityOf = validityOf;
    }

    public String getTypeOfActivity() {
        return typeOfActivity;
    }

    public void setTypeOfActivity(String typeOfActivity) {
        this.typeOfActivity = typeOfActivity;
    }

    public String getAuthorityIssuedLicense() {
        return authorityIssuedLicense;
    }

    public void setAuthorityIssuedLicense(String authorityIssuedLicense) {
        this.authorityIssuedLicense = authorityIssuedLicense;
    }

    public long getNumberOfDecisionAboutIssue() {
        return numberOfDecisionAboutIssue;
    }

    public void setNumberOfDecisionAboutIssue(long numberOfDecisionAboutIssue) {
        this.numberOfDecisionAboutIssue = numberOfDecisionAboutIssue;
    }

    public License() {
        series = "";
        number = 0;
        issueDate = new Date(0);
        validityOf = new Date(0);
        typeOfActivity = "";
        authorityIssuedLicense = "";
        numberOfDecisionAboutIssue = 0;
    }

    public License(String series, long number, Date issueDate, Date validityOf, String typeOfActivity, String authorityIssuedLicense, long numberOfDecisionAboutIssue) {
        this.series = series;
        this.number = number;
        this.issueDate = issueDate;
        this.validityOf = validityOf;
        this.typeOfActivity = typeOfActivity;
        this.authorityIssuedLicense = authorityIssuedLicense;
        this.numberOfDecisionAboutIssue = numberOfDecisionAboutIssue;
    }
}
