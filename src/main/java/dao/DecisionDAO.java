package dao;

import logic.Decision;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface DecisionDAO {
    public void addDecision(Decision decision) throws SQLException;
    public void updateDecision(Decision decision) throws SQLException;
    public Decision getDecisionById(Long decision_id) throws SQLException;
    public Collection getAllDecision() throws SQLException;
    public void deleteDecision(Decision decision) throws SQLException;
}
