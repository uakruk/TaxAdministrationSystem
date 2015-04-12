package main.java.dao;

import main.java.logic.ObjectOfTaxation;
import org.hibernate.Session;
import main.java.util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 02.04.2015.
 */
public class ObjectOfTaxationDAOImplem implements ObjectOfTaxationDAO {
    @Override
    public void addObjectOfTaxation(ObjectOfTaxation objectOfTaxation) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(objectOfTaxation);
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
    public void updateObjectOfTaxation( ObjectOfTaxation objectOfTaxation) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(objectOfTaxation);
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
    public ObjectOfTaxation getObjectOfTaxationById(Long objectOfTaxation_id) throws SQLException {
        Session session = null;
        ObjectOfTaxation objectOfTaxation = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            objectOfTaxation = (ObjectOfTaxation) session.load(ObjectOfTaxation.class, objectOfTaxation_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return objectOfTaxation;
    }

    @Override
    public Collection getAllObjectOfTaxation() throws SQLException {
        return null;
    }

    @Override
    public void deleteObjectOfTaxation(ObjectOfTaxation objectOfTaxation) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(objectOfTaxation);
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
