package wrappers;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Audit {

    private Date startDate;
    private Date endDate;
    private long registrationNumber;
    private String comment;
    private ArrayList<Decision> decisions;
    private TypeOfReason reason;
    private Referral referral;

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

    public TypeOfReason getReason() {
        return reason;
    }

    public void setReason(TypeOfReason reason) {
        this.reason = reason;
    }

    public Referral getReferral() {
        return referral;
    }

    public void setReferral(Referral referral) {
        this.referral = referral;
    }

    public Audit() {
        startDate = new Date(0);
        endDate = new Date(0);
        registrationNumber = 0;
        comment = "";
        decisions = new ArrayList<Decision>();
        reason = new TypeOfReason();
        referral = new Referral();

    }

    public Audit(Date startDate, Date endDate, long registrationNumber, String comment, ArrayList<Decision> decisions, TypeOfReason reason, Referral referral) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.registrationNumber = registrationNumber;
        this.comment = comment;
        this.decisions = decisions;
        this.reason = reason;
        this.referral = referral;
    }
}
