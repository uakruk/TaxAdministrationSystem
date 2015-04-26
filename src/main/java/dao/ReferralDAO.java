package dao;

import logic.Referral;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface ReferralDAO {
<<<<<<< HEAD
    public void addReferral(Referral referral) throws SQLException;
    public void updateReferral(Referral referral) throws SQLException;
=======
    public void addReferral(Referral referral ) throws SQLException;
    public void updateReferral( Referral referral ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Referral getById(Long referral_id) throws SQLException;
    public Collection getAllReferral() throws SQLException;
    public void deleteReferral(Referral referral) throws SQLException;
}
