package dao;

import logic.Decision;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface DecisionDAO {
<<<<<<< HEAD
    public void addDecision(Decision decision) throws SQLException;
    public void updateDecision(Decision decision) throws SQLException;
=======
    public void addDecision( Decision decision) throws SQLException;
    public void updateDecision(Decision decision ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Decision getDecisionById(Long decision_id) throws SQLException;
    public Collection getAllDecision() throws SQLException;
    public void deleteDecision(Decision decision) throws SQLException;
}
