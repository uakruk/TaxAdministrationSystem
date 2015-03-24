package ua.kpi.lab111.obd.group3.taxadministrationsystem;

import java.util.ArrayList;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Taxpayer {

    private long ID;
    private String fullName;
    private ArrayList<Tax> taxes;
    private ArrayList<Contact> contacts;
    private ArrayList<License> licenses;
    private ArrayList<ObjectOfTaxation> objectsOfTaxition;
    private ArrayList<Property> property;
    private ArrayList<Audit> audits;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public ArrayList<Tax> getTaxes() {
        return taxes;
    }

    public void setTaxes(ArrayList<Tax> taxes) {
        this.taxes = taxes;
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(ArrayList<Contact> contacts) {
        this.contacts = contacts;
    }

    public ArrayList<License> getLicenses() {
        return licenses;
    }

    public void setLicenses(ArrayList<License> licenses) {
        this.licenses = licenses;
    }

    public ArrayList<ObjectOfTaxation> getObjectsOfTaxition() {
        return objectsOfTaxition;
    }

    public void setObjectsOfTaxition(ArrayList<ObjectOfTaxation> objectsOfTaxition) {
        this.objectsOfTaxition = objectsOfTaxition;
    }

    public ArrayList<Property> getProperty() {
        return property;
    }

    public void setProperty(ArrayList<Property> property) {
        this.property = property;
    }

    public ArrayList<Audit> getAudits() {
        return audits;
    }

    public void setAudits(ArrayList<Audit> audits) {
        this.audits = audits;
    }

    public Taxpayer() {
        ID = 0;
        fullName = "";
        taxes = new ArrayList<Tax>();
        contacts = new ArrayList<Contact>();
        licenses = new ArrayList<License>();
        objectsOfTaxition = new ArrayList<ObjectOfTaxation>();
        property = new ArrayList<Property>();
        audits = new ArrayList<Audit>();
    }

    public Taxpayer(long ID, String fullName, ArrayList<Tax> taxes, ArrayList<Contact> contacts, ArrayList<License> licenses, ArrayList<ObjectOfTaxation> objectsOfTaxition, ArrayList<Property> property, ArrayList<Audit> audits) {
        this.ID = ID;
        this.fullName = fullName;
        this.taxes = taxes;
        this.contacts = contacts;
        this.licenses = licenses;
        this.objectsOfTaxition = objectsOfTaxition;
        this.property = property;
        this.audits = audits;
    }
}
