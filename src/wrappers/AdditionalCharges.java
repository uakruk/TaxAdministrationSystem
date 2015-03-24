package ua.kpi.lab111.obd.group3.taxadministrationsystem;

import java.sql.Date;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class AdditionalCharges {

    private double sum;
    private Date dateOfCharge;
    private Date term;
    private TypeOfAdditionalCharge type;

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Date getDateOfCharge() {
        return dateOfCharge;
    }

    public void setDateOfCharge(Date dateOfCharge) {
        this.dateOfCharge = dateOfCharge;
    }

    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }

    public TypeOfAdditionalCharge getType() {
        return type;
    }

    public void setType(TypeOfAdditionalCharge type) {
        this.type = type;
    }

    public AdditionalCharges() {
        sum = 0;
        dateOfCharge = new Date(0);
        term = new Date(0);
        type = new TypeOfAdditionalCharge();
    }

    public AdditionalCharges(double sum, Date dateOfCharge, Date term, TypeOfAdditionalCharge type) {
        this.sum = sum;
        this.dateOfCharge = dateOfCharge;
        this.term = term;
        this.type = type;
    }
}
