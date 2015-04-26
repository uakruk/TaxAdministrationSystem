package dao;

import logic.CashRegister;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface CashRegisterDAO {
<<<<<<< HEAD
    public void addCashRegister(CashRegister cashRegister) throws SQLException;
    public void updateCashRegister(CashRegister cashRegister) throws SQLException;
=======
    public void addCashRegister(CashRegister cashRegister ) throws SQLException;
    public void updateCashRegister(CashRegister cashRegister ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public CashRegister getCashRegisterById(Long cashregister_id) throws SQLException;
    public Collection getAllCashRegister() throws SQLException;
    public void deleteCashRegister(CashRegister cashRegister) throws SQLException;
}
