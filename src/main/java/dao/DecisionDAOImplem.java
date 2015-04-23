package dao;

import logic.Decision;
import org.hibernate.Session;
import util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 02.04.2015.
 */
public class DecisionDAOImplem implements DecisionDAO {
    @Override
    public void addDecision(Decision decision) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(decision);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }

    @Override
    public void updateDecision(Decision decision) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(decision);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    @Override
    public Decision getDecisionById(Long decision_id) throws SQLException {
        Session session = null;
        Decision decision = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            decision = (Decision) session.load(Decision.class, decision_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return decision;
    }

    @Override
    public Collection getAllDecision() throws SQLException {
        return null;
    }

    @Override
    public void deleteDecision(Decision decision) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(decision);
            session.getTransaction().commit();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка при вставке", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {

                session.close();
            }
        }
    }
}
