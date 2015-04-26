package dao;

import logic.ObjectOfTaxation;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface ObjectOfTaxationDAO {
    public void addObjectOfTaxation(ObjectOfTaxation objectOfTaxation) throws SQLException;
<<<<<<< HEAD
    public void updateObjectOfTaxation(ObjectOfTaxation objectOfTaxation) throws SQLException;
=======
    public void updateObjectOfTaxation(ObjectOfTaxation objectOfTaxation ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public ObjectOfTaxation getObjectOfTaxationById(Long objectOfTaxation) throws SQLException;
    public Collection getAllObjectOfTaxation() throws SQLException;
    public void deleteObjectOfTaxation(ObjectOfTaxation objectOfTaxation) throws SQLException;
}
