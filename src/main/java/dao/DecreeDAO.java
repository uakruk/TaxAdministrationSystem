package dao;

import logic.Decree;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface DecreeDAO {
<<<<<<< HEAD
    public void addDecree(Decree decree) throws SQLException;
    public void updateDecree(Decree decree) throws SQLException;
=======
    public void addDecree(Decree decree ) throws SQLException;
    public void updateDecree(Decree decree ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Decree getDecreeById(Long decree_id) throws SQLException;
    public Collection getAllDecree() throws SQLException;
    public void deleteDecree(Decree decree) throws SQLException;
}
