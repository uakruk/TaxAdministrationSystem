package dao;

import logic.Property;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface PropertyDAO {
    public void addProperty(Property property) throws SQLException;
    public void updateProperty(Property property) throws SQLException;
    public Property getPropertyById(Long property_id) throws SQLException;
    public Collection getAllProperty() throws SQLException;
    public void deleteProperty(Property property) throws SQLException;
}