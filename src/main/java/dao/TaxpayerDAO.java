package dao;

import logic.Taxpayer;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface TaxpayerDAO {
<<<<<<< HEAD
    public void addTaxpayer(Taxpayer taxpayer) throws SQLException;//y
    public void updateTaxpayer(Taxpayer taxpayer) throws SQLException;//y
=======
    public void addTaxpayer(Taxpayer taxpayer ) throws SQLException;//y
    public void updateTaxpayer(Taxpayer taxpayer ) throws SQLException;//y
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Taxpayer getTaxpayerById(Long ID) throws SQLException;//y
    public Collection getAllTaxpayer() throws SQLException;
    public void deleteTaxpayer(Taxpayer taxpayer) throws SQLException;
}
