package ua.kpi.lab111.obd.group3.taxadministrationsystem;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Unit {
    
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Unit() {
        title = "";
    }

    public Unit(String title) {
        this.title = title;
    }
}
