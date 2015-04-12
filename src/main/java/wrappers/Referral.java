package wrappers;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class Referral {

    private Decree decree;
    private Employee employee;

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

    public Referral() {
        decree = new Decree();
        employee = new Employee();
    }

    public Referral(Decree decree, Employee employee) {
        this.decree = decree;
        this.employee = employee;
    }
}
