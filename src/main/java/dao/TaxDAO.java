package dao;

import logic.Tax;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface TaxDAO {
<<<<<<< HEAD
    public void addTax(Tax tax) throws SQLException;
=======
    public void addTax(Tax tax ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public void updateTax(Tax tax) throws SQLException;
    public Tax getTaxById(Long tax_id) throws SQLException;
    public Collection getAllTax() throws SQLException;
    public void deleteTax(Tax tax) throws SQLException;
}
