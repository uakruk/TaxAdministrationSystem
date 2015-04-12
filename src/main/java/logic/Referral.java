package logic;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="referral")
public class Referral {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long referral_id;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="decree_id")
    private Decree decree;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;

    @OneToMany(mappedBy = "referral")
    private Collection<Audit> audits = new ArrayList<Audit>();

    public Long getReferral_id() {
        return referral_id;
    }

    public void setReferral_id(Long referral_id) {
        this.referral_id = referral_id;
    }
    public Decree getDecree() {
        return decree;
    }

    public void setDecree(Decree decree) {
        this.decree = decree;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public Collection<Audit> getAudits() {
        return audits;
    }

    public void setAudits(Collection<Audit> audits) {
        this.audits = audits;
    }

    public Referral() {
        decree = new Decree();
        employee = new Employee();
        audits = new ArrayList<Audit>();
    }

    public Referral(Decree decree, Employee employee, ArrayList<Audit> audits ) {
        this.decree = decree;
        this.employee = employee;
        this.audits = audits;
    }
}