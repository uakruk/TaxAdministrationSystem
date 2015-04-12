package main.java.dao;

import main.java.logic.Tax;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface TaxDAO {
    public void addTax(Tax tax) throws SQLException;
    public void updateTax(Tax tax) throws SQLException;
    public Tax getTaxById(Long tax_id) throws SQLException;
    public Collection getAllTax() throws SQLException;
    public void deleteTax(Tax tax) throws SQLException;
}
