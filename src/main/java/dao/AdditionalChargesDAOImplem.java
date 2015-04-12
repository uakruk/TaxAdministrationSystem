package main.java.dao;

import main.java.logic.AdditionalCharges;
import org.hibernate.Session;
import main.java.util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 02.04.2015.
 */
public class AdditionalChargesDAOImplem implements AdditionalChargesDAO {
    @Override
    public void addAdditionalCharges(AdditionalCharges additionalCharges) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(additionalCharges);
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
    public void updateAdditionalCharges(AdditionalCharges additionalCharges) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(additionalCharges);
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
    public AdditionalCharges getAdditionalChargesById(Long additionalCharges_id) throws SQLException {
        Session session = null;
        AdditionalCharges additionalCharges = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            additionalCharges = (AdditionalCharges) session.load(AdditionalCharges.class, additionalCharges_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return additionalCharges;
    }

    @Override
    public Collection getAllAdditionalCharges() throws SQLException {
        return null;
    }

    @Override
    public void deleteAdditionalCharges(AdditionalCharges additionalCharges) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(additionalCharges);
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
