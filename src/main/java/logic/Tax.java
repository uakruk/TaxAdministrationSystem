package logic;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Admon on 05.04.2015.
 */
@Entity
@Table(name="tax")
public class Tax {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tax_id;
    @Column(name = "startDate")
    private Date startDate;
    @Column(name = "endDate")
    private Date endDate;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="taxpayer_id")
    private Taxpayer taxpayer;
    @Column(name = "typeOfTax")
    private String typeOfTax;
    @OneToMany(mappedBy = "tax")
    private Collection<Payment> payments = new ArrayList<Payment>();
    @OneToMany(mappedBy = "tax")
    private Collection<AdditionalCharges> additionalCharges = new ArrayList<AdditionalCharges>();

    public Long getTax_id() {
        return tax_id;
    }

    public void setTax_id(Long tax_id) {
        this.tax_id = tax_id;
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

    public void setTypeOfTax(String typeOfTax) {
        this.typeOfTax = typeOfTax;
    }

    public Taxpayer getTaxpayer() {return taxpayer;}

    public void setTaxpayer(Taxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public Collection<AdditionalCharges> getAdditionalCharges() {
        return additionalCharges;
    }

    public void setAdditionalCharges(ArrayList<AdditionalCharges> additionalCharges) {
        this.additionalCharges = additionalCharges;
    }

    public String getTypeOfTax() {
        return typeOfTax;
    }

    public Collection<Payment> getPayments() {
        return payments;
    }

    public void setPayments(Collection<Payment> payments) {
        this.payments = payments;
    }

    public Tax() {
        startDate = new Date(0);
        endDate = new Date(0);
        typeOfTax = new String();
        taxpayer = new Taxpayer();
        additionalCharges = new ArrayList<AdditionalCharges>();
        payments = new ArrayList<Payment>();
    }

    public Tax(Date startDate, Date endDate, String typeOfTax, Taxpayer taxpayer, ArrayList<AdditionalCharges> additionalCharges,ArrayList<Payment> payments) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.typeOfTax = typeOfTax;
        this.taxpayer = taxpayer;
        this.additionalCharges = additionalCharges;
        this.payments = payments;
    }
}
