package dao;

import logic.License;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface LicenseDAO {
<<<<<<< HEAD
    public void addLicense(License license) throws SQLException;
    public void updateLicense(License license) throws SQLException;
=======
    public void addLicense(License license ) throws SQLException;
    public void updateLicense(License license ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public License getLicenseById(Long license_id) throws SQLException;
    public Collection getAllLicense() throws SQLException;
    public void deleteLicense(License license) throws SQLException;

}
