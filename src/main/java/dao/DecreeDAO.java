package dao;

import logic.Decree;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface DecreeDAO {
    public void addDecree(Decree decree ) throws SQLException;
    public void updateDecree(Decree decree ) throws SQLException;
    public Decree getDecreeById(Long decree_id) throws SQLException;
    public Collection getAllDecree() throws SQLException;
    public void deleteDecree(Decree decree) throws SQLException;
}
