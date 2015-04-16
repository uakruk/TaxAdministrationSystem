package logic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employee_id;
    @Column(name = "name")
    private String name;
    @Column(name = "registration")
    private String position;
    @OneToMany(mappedBy = "employee")
    private Collection<Referral> referral = new ArrayList<Referral>();
    @OneToMany(mappedBy = "employee")
    private Collection<Decision> decisions = new ArrayList<Decision>();
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="unit_id")
    private Unit unit;

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

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
        return unit;
    }

    public void setUnitBelongs(Unit unit) {
        this.unit = unit;
    }

    public Collection<Referral> getReferral() {
        return referral;
    }

    public void setReferral(ArrayList<Referral> referral) {
        this.referral = referral;
    }

    public Collection<Decision> getDecisions() {
        return decisions;
    }

    public void setDecisions(Collection<Decision> decisions) {
        this.decisions = decisions;
    }


    public Employee() {
        name = "";
        position = "";
        unit = new Unit();
        referral = new ArrayList<Referral>();
        decisions = new ArrayList<Decision>();
    }

    public Employee(String name, String position, Unit unitBelongs, ArrayList<Referral> referral, ArrayList<Decision> decisions) {
        this.name = name;
        this.position = position;
        this.unit = unitBelongs;
        this.referral = referral;
        this.decisions = decisions;
    }
}