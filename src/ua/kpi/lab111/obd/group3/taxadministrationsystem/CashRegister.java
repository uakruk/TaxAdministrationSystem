package ua.kpi.lab111.obd.group3.taxadministrationsystem;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class CashRegister {

    private long ID;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public CashRegister() {
        ID = 0;
    }

    public CashRegister(long ID) {
        this.ID = ID;
    }
}
