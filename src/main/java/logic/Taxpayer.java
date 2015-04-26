package logic;

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
    private Long taxpayer_id;

    @Column(name = "fullName")
    private String fullName;

<<<<<<< HEAD
    @Column(name = "password")
    private String password;

    @Column(name = "rights")
    private String rights;

=======
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    @OneToMany(mappedBy = "taxpayer")
    private Collection<Tax> taxes = new ArrayList<Tax>();

    @OneToMany(mappedBy = "taxpayer")
    private Collection<License> licenses = new ArrayList<License>();

    @OneToMany(mappedBy = "taxpayer")
    private List<ObjectOfTaxation> objectOfTaxations = new ArrayList<ObjectOfTaxation>();

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

<<<<<<< HEAD
    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

=======
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
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

    public List<ObjectOfTaxation> getObjectOfTaxations() {
        return objectOfTaxations;
    }

    public void setObjectOfTaxations(List<ObjectOfTaxation> objectOfTaxations) {
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

<<<<<<< HEAD
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Taxpayer() {
        password = "";
=======
    public Taxpayer() {
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
        fullName = "";
        taxes = new ArrayList<Tax>();
        licenses = new ArrayList<License>();
        propertys = new ArrayList<Property>();
        objectOfTaxations = new ArrayList<ObjectOfTaxation>();
        audits = new ArrayList<Audit>();
        contacts = new ArrayList<Contact>();
    }

<<<<<<< HEAD
    public Taxpayer(long ID, String fullName,String password,ArrayList<Tax> taxes, ArrayList<License> licenses, ArrayList<ObjectOfTaxation> objectOfTaxations, ArrayList<Audit> audits, ArrayList<Property> propertys, ArrayList<Contact> contacts) {
        this.fullName = fullName;
        this.password = password;
=======
    public Taxpayer(long ID, String fullName,ArrayList<Tax> taxes, ArrayList<License> licenses, ArrayList<ObjectOfTaxation> objectOfTaxations, ArrayList<Audit> audits, ArrayList<Property> propertys, ArrayList<Contact> contacts) {
        this.fullName = fullName;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
        this.taxes = taxes;
        this.licenses = licenses;
        this.propertys = propertys;
        this.objectOfTaxations = objectOfTaxations;
        this.audits = audits;
        this.contacts = contacts;
    }
}
