package main.java.logic;
import javax.persistence.*;

import java.sql.Date;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="AdditionalCharges")
public class AdditionalCharges {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long additionalCharges_id;
    @Column(name = "sum")
    private double sum;
    @Column(name = "dateOfCharge")
    private Date dateOfCharge;
    @Column(name = "term")
    private Date term;
    @Column(name = "typeOfAdditionalCharges")
    private String typeOfAdditionalCharge;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="tax_id")
    private Tax tax;
    public Long getAdditionalCharges_id() {
        return additionalCharges_id;
    }

    public void setAdditionalCharges_id(Long additionalCharges_id) {
        this.additionalCharges_id = additionalCharges_id;
    }

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

    public String getTypeOfAdditionalCharge() {
        return typeOfAdditionalCharge;
    }

    public void setTypeTypeOfAdditionalCharge(String typeOfAdditionalCharge) {
        this.typeOfAdditionalCharge = typeOfAdditionalCharge;
    }

    public Tax getTax() {
        return tax;
    }

    public void setTax(Tax tax) {
        this.tax = tax;
    }

    public AdditionalCharges() {
        sum = 0;
        dateOfCharge = new Date(0);
        term = new Date(0);
        typeOfAdditionalCharge = new String();
        tax = new Tax();
    }

    public AdditionalCharges(double sum, Date dateOfCharge, Date term, String typeOfAdditionalCharge, Tax tax) {
        this.sum = sum;
        this.dateOfCharge = dateOfCharge;
        this.term = term;
        this.typeOfAdditionalCharge = typeOfAdditionalCharge;
        this.tax = tax;
    }
}