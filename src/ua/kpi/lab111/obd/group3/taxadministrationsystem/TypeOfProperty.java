package ua.kpi.lab111.obd.group3.taxadministrationsystem;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class TypeOfProperty {

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public TypeOfProperty() {
        title = "";
    }

    public TypeOfProperty(String title) {
        this.title = title;
    }
}
