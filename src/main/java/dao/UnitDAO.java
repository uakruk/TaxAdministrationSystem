package dao;

import logic.Unit;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface UnitDAO {
    public void addUnit(Unit  unit ) throws SQLException;
    public void updateUnit(Unit unit ) throws SQLException;
    public Unit getUnitById(Long unit_id) throws SQLException;
    public Collection getAllUnit() throws SQLException;
    public void deleteUnit(Unit unit) throws SQLException;
}
