package logic;
import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
<<<<<<< HEAD
@Table(name="audit")
=======
@Table(name="Audit")
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
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
<<<<<<< HEAD
  //  @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
   // @JoinColumn(name="referral_id")
    @OneToMany(mappedBy = "audit")
    private Collection<Referral> referrals = new ArrayList<Referral>();
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="taxpayer_id")
    private Taxpayer taxpayer;
    @OneToMany(mappedBy = "audit")
    private Collection<Decision> decisions = new ArrayList<Decision>();
=======
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="referral_id")
    private ArrayList<Referral> referrals = new ArrayList<Referral>();
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="taxpayer_id")
    private Taxpayer taxpayer;

    /**VALIK! PAY ATTENTION FOR THIS!*/

    @OneToMany
    private ArrayList<Decision> decisions;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3

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

<<<<<<< HEAD
    public Collection<Decision> getDecisions() {
=======
    public ArrayList<Decision> getDecisions() {
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
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
<<<<<<< HEAD

    public Collection<Referral> getReferrals() {
        return referrals;
    }

    public void setReferral(Collection<Referral> referral) {
        this.referrals = referral;
    }

=======
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
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
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
<<<<<<< HEAD
        decisions = new ArrayList<Decision>();
        reason = new String();
        referrals = new ArrayList<Referral>();

    }

    public Audit(Date startDate, Date endDate, long registrationNumber, String comment,String reason, ArrayList<Referral> referral, ArrayList<Decision> decisions) {
=======
        //decisions = new ArrayList<Decision>();
        reason = new String();
        referrals = new ArrayList<Referral>();
    }

    public Audit(Date startDate, Date endDate, long registrationNumber, String comment,String reason, ArrayList<Referral> referrals) {
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationNumber = registrationNumber;
        this.comment = comment;
<<<<<<< HEAD
        this.decisions = decisions;
        this.reason = reason;
        this.referrals = referral;
=======
        //this.decisions = decisions;
        this.reason = reason;
        this.referrals = referrals;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    }
}