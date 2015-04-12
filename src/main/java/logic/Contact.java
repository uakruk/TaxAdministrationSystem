package main.java.logic;

import javax.persistence.*;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="Contact")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long contact_id;

    @Column(name = "value")
    private String value;

    @Column(name = "typeOfContact")
    private String typeOfContact;

    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="taxpayer_id")
    private Taxpayer taxpayer;

    public Long getContact_id() {
        return contact_id;
    }

    public void setContact_id(Long contact_id) {
        this.contact_id = contact_id;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTypeOfContact() {
        return typeOfContact;
    }

    public void setTypeOfContact(String typeOfContact) {
        this.typeOfContact = typeOfContact;
    }

    public Taxpayer getTaxpayer() {
        return taxpayer;
    }

    public void setTaxpayer(Taxpayer taxpayer) {
        this.taxpayer = taxpayer;
    }

    public Contact() {
        value = "";
        typeOfContact = new String("");
        taxpayer = new Taxpayer();
    }

    public Contact(String value, String typeOfContact, Taxpayer taxpayer) {
        this.value = value;
        this.typeOfContact = typeOfContact;
        this.taxpayer = taxpayer;
    }
}