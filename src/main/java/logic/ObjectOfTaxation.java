package logic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="ObjectOfTaxation")
public class ObjectOfTaxation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long objectOfTaxation_id;
    @Column(name = "title")
    private String title;
    @Column(name = "address")
    private String address;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="taxpayer_id")
    private Taxpayer taxpayer;
    @OneToMany(mappedBy = "objectOfTaxation")
    private Collection<CashRegister> cashRegisters = new ArrayList<CashRegister>();

    public Long getObjectOfTaxation_id() {
        return objectOfTaxation_id;
    }

    public void setObjectOfTaxation_id(Long objectOfTaxation_id) {
        this.objectOfTaxation_id = objectOfTaxation_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Taxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(Taxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public Collection<CashRegister> getCashRegisters() {
        return cashRegisters;
    }

    public void setCashRegisters(Collection<CashRegister> cashRegisters) {
        this.cashRegisters = cashRegisters;
    }

    public ObjectOfTaxation() {
        title = "";
        address = "";
        taxpayer = new Taxpayer();
        cashRegisters = new ArrayList<CashRegister>();
    }

    public ObjectOfTaxation(String title, String address, Taxpayer taxpayer, ArrayList<CashRegister> cashRegisters) {
        this.title = title;
        this.address = address;
        this.taxpayer = taxpayer;
        this.cashRegisters = cashRegisters;
    }
}