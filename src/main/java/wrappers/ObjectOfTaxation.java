package wrappers;

import java.util.ArrayList;

/**
 * @author Yaroslav Kruk on 18.11.14
 * @version 1.0
 * @since 1.7
 */
public class ObjectOfTaxation {

    private String title;
    private String address;
    private ArrayList<CashRegister> cashRegisters;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ArrayList<CashRegister> getCashRegisters() {
        return cashRegisters;
    }

    public void setCashRegisters(ArrayList<CashRegister> cashRegisters) {
        this.cashRegisters = cashRegisters;
    }

    public ObjectOfTaxation() {
        title = "";
        address = "";
        cashRegisters = new ArrayList<CashRegister>();
    }

    public ObjectOfTaxation(String title, String address, ArrayList<CashRegister> cashRegisters) {
        this.title = title;
        this.address = address;
        this.cashRegisters = cashRegisters;
    }
}
