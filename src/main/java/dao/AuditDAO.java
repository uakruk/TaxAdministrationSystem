package dao;

import logic.Audit;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface AuditDAO {
    public void addAudit(Audit audit) throws SQLException;
    public void updateAudit(Audit audit) throws SQLException;
    public Audit getAuditById(Long audit_id) throws SQLException;
    public Collection getAllAudit() throws SQLException;
    public void deleteAudit(Audit audit) throws SQLException;
}
