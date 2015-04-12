package main.java.dao;

import main.java.logic.Contact;
import org.hibernate.Session;
import main.java.util.HibernateUtil;

import javax.swing.*;
import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 02.04.2015.
 */
public class ContactDAOImplem implements ContactDAO {
    @Override
    public void addContact(Contact contact) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(contact);
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
    public void updateContact(Contact contact) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(contact);
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
    public Contact getContactById(Long contact_id) throws SQLException {
        Session session = null;
        Contact contact = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            contact = (Contact) session.load(Contact.class, contact_id);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка 'findById'", JOptionPane.OK_OPTION);
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contact;
    }

    @Override
    public Collection getAllContact() throws SQLException {
        return null;
    }

    @Override
    public void deleteContact(Contact contact) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(contact);
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
