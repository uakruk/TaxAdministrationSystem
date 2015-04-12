package main.java.logic;

import javax.persistence.*;
import java.sql.Date;
/**
 * Created by Admon on 27.03.2015.
 */
@Entity
@Table(name="License")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long license_id;
    @Column(name = "series")
    private String series;
    @Column(name = "number")
    private long number;
    @Column(name = "issueDate")
    private Date issueDate;
    @Column(name = "validityOf")
    private Date validityOf;
    @Column(name = "typeOfActivity")
    private String typeOfActivity;
    @Column(name = "authorityIssuedLicense")
    private String authorityIssuedLicense;
    @Column(name = "numberOfDecisionAboutIssue")
    private long numberOfDecisionAboutIssue;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="taxpayer_id")
    private Taxpayer taxpayer;

    public Long getLicense_id() {
        return license_id;
    }

    public void setLicense_id(Long license_id) {
        this.license_id = license_id;
    }


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

    public Taxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(Taxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public License() {
        series = "";
        number = 0;
        issueDate = new Date(0);
        validityOf = new Date(0);
        typeOfActivity = "";
        authorityIssuedLicense = "";
        numberOfDecisionAboutIssue = 0;
        taxpayer = new Taxpayer();
    }

    public License(String series, long number, Date issueDate, Date validityOf, String typeOfActivity, String authorityIssuedLicense, long numberOfDecisionAboutIssue, Taxpayer taxpayer) {
        this.series = series;
        this.number = number;
        this.issueDate = issueDate;
        this.validityOf = validityOf;
        this.typeOfActivity = typeOfActivity;
        this.authorityIssuedLicense = authorityIssuedLicense;
        this.numberOfDecisionAboutIssue = numberOfDecisionAboutIssue;
        this.taxpayer = taxpayer;
    }
}