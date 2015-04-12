package dao;

import logic.Taxpayer;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface TaxpayerDAO {
    public void addTaxpayer(Taxpayer taxpayer ) throws SQLException;//y
    public void updateTaxpayer(Taxpayer taxpayer ) throws SQLException;//y
    public Taxpayer getTaxpayerById(Long ID) throws SQLException;//y
    public Collection getAllTaxpayer() throws SQLException;
    public void deleteTaxpayer(Taxpayer taxpayer) throws SQLException;
}
