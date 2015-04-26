package dao;

import logic.Employee;

import java.sql.SQLException;
import java.util.Collection;

/**
 * Created by Admon on 27.03.2015.
 */
public interface EmployeeDAO {
<<<<<<< HEAD
    public void addEmployee(Employee employee) throws SQLException;
    public void updateEmployee(Employee employee) throws SQLException;
=======
    public void addEmployee(Employee employee ) throws SQLException;
    public void updateEmployee(Employee employee ) throws SQLException;
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
    public Employee getEmployeeById(Long employee_id) throws SQLException;
    public Collection getAllEmployee() throws SQLException;
    public void deleteEmployee(Employee employee) throws SQLException;
}
