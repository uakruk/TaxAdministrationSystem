package main.java.dao;

import main.java.logic.Taxpayer;
import org.hibernate.Session;
import main.java.util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 30.03.2015.
 */
public class TaxpayerDAOImplem implements TaxpayerDAO {
    @Override
    public void addTaxpayer(Taxpayer taxpayer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(taxpayer);
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
    public void updateTaxpayer(Taxpayer taxpayer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(taxpayer);
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
    public Taxpayer getTaxpayerById(Long taxpayer_id) throws SQLException {
        Session session = null;
        Taxpayer taxpayer = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            taxpayer = (Taxpayer) session.load(Taxpayer.class, taxpayer_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return taxpayer;
    }

    @Override
    public Collection getAllTaxpayer() throws SQLException {
        return null;
    }

    @Override
    public void deleteTaxpayer(Taxpayer taxpayer) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(taxpayer);
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
