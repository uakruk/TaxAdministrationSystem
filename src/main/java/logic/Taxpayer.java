package main.java.logic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="Taxpayer")
public class Taxpayer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long taxpayer_id;

    @Column(name = "idCode")
    private long idCode;

    @Column(name = "fullName")
    private String fullName;

    @OneToMany(mappedBy = "taxpayer")
    private Collection<Tax> taxes = new ArrayList<Tax>();

    @OneToMany(mappedBy = "taxpayer")
    private Collection<License> licenses = new ArrayList<License>();

    @OneToMany(mappedBy = "taxpayer")
    private Collection<ObjectOfTaxation> objectOfTaxations = new ArrayList<ObjectOfTaxation>();

    @OneToMany(mappedBy = "taxpayer")
    private Collection<Property> propertys = new ArrayList<Property>();

    @OneToMany(mappedBy = "taxpayer")
    private Collection<Audit> audits = new ArrayList<Audit>();

    @OneToMany(mappedBy = "taxpayer")
    private Collection<Contact> contacts = new ArrayList<Contact>();

    public Long getTaxpayer_id() {
        return taxpayer_id;
    }

    public void setTaxpayer_id(Long id) {
        this.taxpayer_id = id;
    }

    public long getIdCode() {
        return idCode;
    }

    public void setIdCode(long ID) {
        this.idCode = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Collection<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(Collection<Tax> taxes) {
        this.taxes = taxes;
    }


    public Collection<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(Collection<License> licenses) {
        this.licenses = licenses;
    }

    public Collection<ObjectOfTaxation> getObjectOfTaxations() {
        return objectOfTaxations;
    }

    public void setObjectOfTaxations(Collection<ObjectOfTaxation> objectOfTaxations) {
        this.objectOfTaxations = objectOfTaxations;
    }

    public Collection<Property> getPropertys() {
        return propertys;
    }

    public void setPropertys(Collection<Property> propertys) {
        this.propertys = propertys;
    }

    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public Collection<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(Collection<Contact> contacts) {
        this.contacts = contacts;
    }

    public Taxpayer() {
        idCode = 0;
        fullName = "";
        taxes = new ArrayList<Tax>();
        licenses = new ArrayList<License>();
        propertys = new ArrayList<Property>();
        objectOfTaxations = new ArrayList<ObjectOfTaxation>();
        audits = new ArrayList<Audit>();
        contacts = new ArrayList<Contact>();
    }

    public Taxpayer(long ID, String fullName,ArrayList<Tax> taxes, ArrayList<License> licenses, ArrayList<ObjectOfTaxation> objectOfTaxations, ArrayList<Audit> audits, ArrayList<Property> propertys, ArrayList<Contact> contacts) {
        this.idCode = ID;
        this.fullName = fullName;
        this.taxes = taxes;
        this.licenses = licenses;
        this.propertys = propertys;
        this.objectOfTaxations = objectOfTaxations;
        this.audits = audits;
        this.contacts = contacts;
    }
}
