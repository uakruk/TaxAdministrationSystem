package restful.resources;

import dao.EmployeeDAO;
import dao.Factory;
import logic.Unit;
import logic.Employee;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 14.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public abstract class EmployeeRes {
    /*because*/
    private static Factory factory = Factory.getInstance();
    private static EmployeeDAO dao = factory.getEmployeeDAO();
    private static EmployeeDAO getDao() {
        factory = factory.equals(null) ? Factory.getInstance() : factory;
        dao = dao.equals(null) ? factory.getEmployeeDAO() : dao;
        return dao;
    }

    /**
     * get employees by unit_id
     * @param unit_id
     * @return
     */
    public static JSONArray getAllEmployeesByUnitId(long unit_id) {
        JSONObject temp;
        JSONArray resp = new JSONArray();
        try {
            dao = getDao();
            Unit u = factory.getUnitDAO().getUnitById(unit_id);
            Collection<Employee> col = u.getEmployees();
            Iterator<Employee> iter = col.iterator();
            while (iter.hasNext()) {
                temp = new JSONObject();
                Employee e = iter.next();
                temp.put("employee_id", e.getEmployee_id());
                temp.put("name", e.getName());
                temp.put("position", e.getPosition());
                resp.put(temp);
            }
            temp = new JSONObject();
            temp.put("MSG", "Items have been delivered successfully");
            temp.put("HTTP_CODE", "200");
            resp.put(temp);
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while processing a JSON");
                temp.put("HTTP_CODE", "500");
                resp.put(temp);
            } catch (JSONException n) {
                e.printStackTrace();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
                resp.put(temp);
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return resp;
    }

    /**
     * get employee by employee_id
     * @param employee_id
     * @return
     */
    public static JSONObject getEmployeeById(long employee_id) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Employee e = dao.getEmployeeById(employee_id);
            temp.put("employee_id", e.getEmployee_id());
            temp.put("name", e.getName());
            temp.put("position", e.getPosition());
            temp.put("MSG", "Item has been delivered successfully");
            temp.put("HTTP_CODE", "200");
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while processing a JSON");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                e.printStackTrace();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * update employee by employee_id
     * @param employee_id
     * @return
     */
    public static synchronized JSONObject updateEmployeeById(long employee_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Employee e = dao.getEmployeeById(employee_id);
            e.setName(src.optString("name"));
            e.setPosition(src.optString("position"));
            dao.updateEmployee(e);
            temp.put("MSG", "Item has been updated successfully");
            temp.put("HTTP_CODE", "200");
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while processing a JSON");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                e.printStackTrace();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * add employee by unit_id
     * @param unit_id
     * @return
     */
    public static synchronized JSONObject addEmployeeByUnitId(long unit_id, JSONObject src) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Unit u = factory.getUnitDAO().getUnitById(unit_id);
            Employee e = new Employee();
            e.setName(src.optString("name"));
            e.setPosition(src.optString("position"));
            e.setUnitBelongs(u);
            dao.addEmployee(e);
            temp.put("MSG", "Item has been added successfully");
            temp.put("HTTP_CODE", "200");
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while processing a JSON");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                e.printStackTrace();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }

    /**
     * delete employee by employee_id
     * @param employee_id
     * @return
     */
    public static synchronized JSONObject deleteEmployeeById(long employee_id) {
        JSONObject temp = new JSONObject();
        try {
            dao = getDao();
            Employee e = dao.getEmployeeById(employee_id);
            dao.deleteEmployee(e);
            temp.put("MSG", "Item has been deleted successfully");
            temp.put("HTTP_CODE", "200");
        } catch (JSONException e) {
            e.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while processing a JSON");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                e.printStackTrace();
            }
        } catch (SQLException a) {
            a.printStackTrace();
            try {
                temp = new JSONObject();
                temp.put("MSG", "Error while executing a SQL querry");
                temp.put("HTTP_CODE", "500");
            } catch (JSONException n) {
                n.printStackTrace();
            }
        }
        return temp;
    }
}
