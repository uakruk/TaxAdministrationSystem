package logic;

import javax.persistence.*;

/**
 * Created by Admon on 27.03.2015.
 */

@Entity
@Table(name="Decision")
public class Decision {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long decision_id;
    @Column(name = "text")
    private String text;
    @Column(name = "chief")
    private String chief;
    @Column(name = "signature")
    private String signature;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="employee_id")
    private Employee employee;
    @ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
<<<<<<< HEAD
    @JoinColumn(name = "audit_id")
    private Audit audit;
=======
    private Audit audit;

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Long getDecision_id() {
        return decision_id;
    }

    public void setDecision_id(Long decision_id) {
        this.decision_id = decision_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getChief() {
        return chief;
    }

    public void setChief(String chief) {
        this.chief = chief;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
<<<<<<< HEAD

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

=======
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Decision() {
        text = "";
        chief = "";
        signature = "";
        employee = new Employee();
<<<<<<< HEAD
        audit = new Audit();
    }

    public Decision(String text, String chief, String signature, Employee employee, Audit audit) {
=======
    }

    public Decision(String text, String chief, String signature, Employee employee) {
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
        this.text = text;
        this.chief = chief;
        this.signature = signature;
        this.employee = employee;
<<<<<<< HEAD
        this.audit = audit;
=======
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    }
}