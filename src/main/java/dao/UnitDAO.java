package dao;

import logic.Unit;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface UnitDAO {
<<<<<<< HEAD
    public void addUnit(Unit unit) throws SQLException;
    public void updateUnit(Unit unit) throws SQLException;
=======
    public void addUnit(Unit  unit ) throws SQLException;
    public void updateUnit(Unit unit ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Unit getUnitById(Long unit_id) throws SQLException;
    public Collection getAllUnit() throws SQLException;
    public void deleteUnit(Unit unit) throws SQLException;
}
