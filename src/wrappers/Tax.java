package ua.kpi.lab111.obd.group3.taxadministrationsystem;

import java.sql.Date;
import java.util.ArrayList;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Tax {

    private Date startDate;
    private Date endDate;
    private ArrayList<Payment> payments;
    private ArrayList<AdditionalCharges> additionalCharges;
    private TypeOfTax typeOfTax;

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

    public ArrayList<Payment> getPayments() {
        return payments;
    }

    public void setPayments(ArrayList<Payment> payments) {
        this.payments = payments;
    }

    public ArrayList<AdditionalCharges> getAdditionalCharges() {
        return additionalCharges;
    }

    public void setAdditionalCharges(ArrayList<AdditionalCharges> additionalCharges) {
        this.additionalCharges = additionalCharges;
    }

    public TypeOfTax getTypeOfTax() {
        return typeOfTax;
    }

    public void setTypeOfTax(TypeOfTax typeOfTax) {
        this.typeOfTax = typeOfTax;
    }

    public Tax() {
        payments = new ArrayList<Payment>();
        startDate = new Date(0);
        endDate = new Date(0);
        additionalCharges = new ArrayList<AdditionalCharges>();
        typeOfTax = new TypeOfTax();
    }

    public Tax(Date startDate, Date endDate, ArrayList<Payment> payments, ArrayList<AdditionalCharges> additionalCharges, TypeOfTax typeOfTax) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.payments = payments;
        this.additionalCharges = additionalCharges;
        this.typeOfTax = typeOfTax;
    }
}
