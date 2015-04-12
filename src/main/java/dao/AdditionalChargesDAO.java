package dao;

import logic.AdditionalCharges;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface AdditionalChargesDAO {
    public void addAdditionalCharges(AdditionalCharges additionalCharges) throws SQLException;
    public void updateAdditionalCharges(AdditionalCharges additionalCharges) throws SQLException;
    public AdditionalCharges getAdditionalChargesById(Long additionalCharges_id) throws SQLException;
    public Collection getAllAdditionalCharges() throws SQLException;
    public void deleteAdditionalCharges(AdditionalCharges additionalCharges) throws SQLException;

}
