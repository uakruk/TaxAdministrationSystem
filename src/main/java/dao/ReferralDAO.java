package main.java.dao;

import main.java.logic.Referral;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface ReferralDAO {
    public void addReferral(Referral referral) throws SQLException;
    public void updateReferral(Referral referral) throws SQLException;
    public Referral getById(Long referral_id) throws SQLException;
    public Collection getAllReferral() throws SQLException;
    public void deleteReferral(Referral referral) throws SQLException;
}
