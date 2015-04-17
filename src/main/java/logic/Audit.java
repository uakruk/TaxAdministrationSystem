package logic;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="Audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long audit_id;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    @Column(name = "registrationNumber")
    private long registrationNumber;
    @Column(name = "commrnt")
    private String comment;
    @Column(name = "reason")
    private String reason;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="referral_id")
    private ArrayList<Referral> referrals = new ArrayList<Referral>();
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="taxpayer_id")
    private Taxpayer taxpayer;

    /**VALIK! PAY ATTENTION FOR THIS!*/

    @OneToMany
    private ArrayList<Decision> decisions;

    public Long getAudit_id() {
        return audit_id;
    }

    public void setAudit_id(Long audit_id) {
        this.audit_id = audit_id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public long getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(long registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public ArrayList<Decision> getDecisions() {
        return decisions;
    }

    public void setDecisions(ArrayList<Decision> decisions) {
        this.decisions = decisions;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
/*
    public Referral getReferral() {
        return referral;
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
    }
*/

    public ArrayList<Referral> getReferrals() {
        return referrals;
    }

    public void setReferrals(ArrayList<Referral> referrals) {
        this.referrals = referrals;
    }
    public Taxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(Taxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public Audit() {
        startDate = new Date(0);
        endDate = new Date(0);
        registrationNumber = 0;
        comment = "";
        //decisions = new ArrayList<Decision>();
        reason = new String();
        referrals = new ArrayList<Referral>();
    }

    public Audit(Date startDate, Date endDate, long registrationNumber, String comment,String reason, ArrayList<Referral> referrals) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationNumber = registrationNumber;
        this.comment = comment;
        //this.decisions = decisions;
        this.reason = reason;
        this.referrals = referrals;
    }
}