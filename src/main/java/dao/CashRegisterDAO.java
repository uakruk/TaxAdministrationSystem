package dao;

import logic.CashRegister;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface CashRegisterDAO {
    public void addCashRegister(CashRegister cashRegister ) throws SQLException;
    public void updateCashRegister(CashRegister cashRegister ) throws SQLException;
    public CashRegister getCashRegisterById(Long cashregister_id) throws SQLException;
    public Collection getAllCashRegister() throws SQLException;
    public void deleteCashRegister(CashRegister cashRegister) throws SQLException;
}
