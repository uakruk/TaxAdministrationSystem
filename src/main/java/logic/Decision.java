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
    private Audit audit;

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }
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
    public Decision() {
        text = "";
        chief = "";
        signature = "";
        employee = new Employee();
    }

    public Decision(String text, String chief, String signature, Employee employee) {
        this.text = text;
        this.chief = chief;
        this.signature = signature;
        this.employee = employee;
    }
}