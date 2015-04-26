package dao;

import logic.Contact;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface ContactDAO {
<<<<<<< HEAD
    public void addContact(Contact contact) throws SQLException;
    public void updateContact(Contact contact) throws SQLException;
=======
    public void addContact( Contact contact) throws SQLException;
    public void updateContact(Contact contact ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Contact getContactById(Long contact_id) throws SQLException;
    public Collection getAllContact() throws SQLException;
    public void deleteContact(Contact contact) throws SQLException;
}
