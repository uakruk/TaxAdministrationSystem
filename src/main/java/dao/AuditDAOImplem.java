package main.java.dao;

import main.java.logic.Audit;
import org.hibernate.Session;
import main.java.util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 02.04.2015.
 */
public class AuditDAOImplem implements AuditDAO {
    @Override
    public void addAudit(Audit audit) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(audit);
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
    public void updateAudit( Audit audit) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(audit);
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
    public Audit getAuditById(Long audit_id) throws SQLException {
        Session session = null;
        Audit audit = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            audit = (Audit) session.load(Audit.class, audit_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return audit;
    }

    @Override
    public Collection getAllAudit() throws SQLException {
        return null;
    }

    @Override
    public void deleteAudit(Audit audit) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(audit);
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
