package ua.kpi.lab111.obd.group3.taxadministrationsystem;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Decision {

    private String text;
    private String chief;
    private String signature;
    private Employee employee;

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
