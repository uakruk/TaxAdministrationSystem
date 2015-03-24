package ua.kpi.lab111.obd.group3.taxadministrationsystem;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Employee {

    private String name;
    private String position;
    private Unit unitBelongs;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Unit getUnitBelongs() {
        return unitBelongs;
    }

    public void setUnitBelongs(Unit unitBelongs) {
        this.unitBelongs = unitBelongs;
    }

    public Employee() {
        name = "";
        position = "";
        unitBelongs = new Unit();
    }

    public Employee(String name, String position, Unit unitBelongs) {
        this.name = name;
        this.position = position;
        this.unitBelongs = unitBelongs;
    }
}
