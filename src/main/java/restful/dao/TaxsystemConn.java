package restful.dao;


import java.sql.Connection;

import javax.naming.*;
import javax.sql.*;
/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 13.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public class TaxsystemConn {

    private static DataSource Taxsystem = null; //hold the database object
    private static Context context = null;

    private static DataSource TaxsystemConn() throws Exception {

        /**
         * check to see if the database object is already defined...
         * if it is, then return the connection, no need to look it up again.
         */
        if (Taxsystem != null) {
            return Taxsystem;
        }

        try {

            /**
             * This only needs to run one time to get the database object.
             * context is used to lookup the database object in weblogic
             * Oracle308tube will hold the database object
             */
            if (context == null) {
                context = new InitialContext();
            }

            Taxsystem = (DataSource) context.lookup("Podatkova");

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return Taxsystem;

    }

    protected static Connection taxsystemConnection() {
        Connection conn = null;
        try {
            conn = TaxsystemConn().getConnection();
            return conn;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
