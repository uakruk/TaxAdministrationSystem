package ua.kpi.lab111.obd.group3.taxadministrationsystem;


/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Contact {

    private String value;
    private TypeOfContact typeOfContact;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public TypeOfContact getTypeOfContact() {
        return typeOfContact;
    }

    public void setTypeOfContact(TypeOfContact typeOfContact) {
        this.typeOfContact = typeOfContact;
    }

    public Contact() {
        value = "";
        typeOfContact = new TypeOfContact();
    }

    public Contact(String value, TypeOfContact typeOfContact) {
        this.value = value;
        this.typeOfContact = typeOfContact;
    }
}
