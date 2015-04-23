package dao;

import logic.Employee;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface EmployeeDAO {
    public void addEmployee(Employee employee) throws SQLException;
    public void updateEmployee(Employee employee) throws SQLException;
    public Employee getEmployeeById(Long employee_id) throws SQLException;
    public Collection getAllEmployee() throws SQLException;
    public void deleteEmployee(Employee employee) throws SQLException;
}
