package dao;

import logic.License;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface LicenseDAO {
    public void addLicense(License license ) throws SQLException;
    public void updateLicense(License license ) throws SQLException;
    public License getLicenseById(Long license_id) throws SQLException;
    public Collection getAllLicense() throws SQLException;
    public void deleteLicense(License license) throws SQLException;

}
