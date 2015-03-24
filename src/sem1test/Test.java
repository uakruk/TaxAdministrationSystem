package ua.kpi.lab111.obd.group3.test;

import ua.kpi.lab111.obd.group3.taxadministrationsystem.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Yaroslav Kruk on 27.11.14
 * @version 1.0
 * @since 1.7
 */
public class Test {
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        try {
            final String userName = "root";
            final String password = "067";
            final String url = "jdbc:mysql://localhost:3306/Podatkova";
            Class.forName ("com.mysql.jdbc.Driver").newInstance();
            conn = DriverManager.getConnection(url, userName, password);

            Statement s = conn.createStatement();
            String query = "SELECT * FROM Taxpayer, Property";
            ResultSet res = s.executeQuery(query);
            HashMap<String, Taxpayer> payers = new HashMap<String, Taxpayer>();
            ArrayList<String> ids = new ArrayList<String>();
         //   int i = 0;
            System.out.println("Connection to database established");
            while(res.next()) {
                if (!payers.containsKey("Taxpayer_id")) {
                    payers.put(res.getString("Taxpayer_id"), new Taxpayer(Long.parseLong(res.getString("Taxpayer_id")),
                            res.getString("Name"), new ArrayList<Tax>(), new ArrayList<Contact>(),
                            new ArrayList<License>(), new ArrayList<ObjectOfTaxation>(),
                            new ArrayList<Property>(), new ArrayList<Audit>()));
                    ids.add(res.getString("Taxpayer_id"));
                }
                payers.get(res.getString("Taxpayer_id")).getProperty().add(new Property((res.getString("Adress")),
                        Double.parseDouble(res.getString("Squere")),
                        Long.parseLong(res.getString("Cadastral_number")), Double.parseDouble(res.getString("Cost")),
                        new TypeOfProperty(res.getString("Property Type_PropertyType_id"))));
          //      i++;
            }
            for (String j : ids) {
            if (payers.containsKey(j)) {
                System.out.println("ID: " + payers.get(j).getID());
                System.out.println("Name: " + payers.get(j).getFullName());
                System.out.println("Property:" );
                System.out.println("{");
                for (int k = 0; k < payers.get(j).getProperty().size(); k++) {
                    System.out.println("Address: " + payers.get(j).getProperty().get(k).getAddress());
                    System.out.println("Cadastrial number:" + payers.get(j).getProperty().get(k).getCadastralNumber());
                    System.out.println("Price: " + payers.get(j).getProperty().get(k).getPrice());
                    System.out.println("Square: " + payers.get(j).getProperty().get(k).getSquare());
                    System.out.println("Type of property: " + payers.get(j).getProperty().get(k).getTypeOfProperty().getTitle());
                }
                System.out.println("}");
            }
            }

        } catch (Exception e) {
            System.out.println("Unable to connect to database");
            System.out.println(e);
            e.printStackTrace();
        } finally {
            if (conn != null)
                conn.close();
        }
    }
}/*Out:
Connection to database established
ID: 1
Name: Vavan is Bycicle
Property:
Address: ProperityAdress3
Cadastrial number:2
Price: 7500.0
Square: 450.0
Type of property: 2
ID: 2
Name: Allah Is Bycicle
Property:
Address: ProperityAdress3
Cadastrial number:2
Price: 7500.0
Square: 450.0
Type of property: 2
ID: 3
Name: Allah Is Bycicle
Property:
Address: ProperityAdress3
Cadastrial number:2
Price: 7500.0
Square: 450.0
Type of property: 2
*///~
