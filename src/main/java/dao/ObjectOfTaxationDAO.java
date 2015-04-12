package main.java.dao;

import main.java.logic.ObjectOfTaxation;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface ObjectOfTaxationDAO {
    public void addObjectOfTaxation(ObjectOfTaxation objectOfTaxation) throws SQLException;
    public void updateObjectOfTaxation(ObjectOfTaxation objectOfTaxation) throws SQLException;
    public ObjectOfTaxation getObjectOfTaxationById(Long objectOfTaxation) throws SQLException;
    public Collection getAllObjectOfTaxation() throws SQLException;
    public void deleteObjectOfTaxation(ObjectOfTaxation objectOfTaxation) throws SQLException;
}
