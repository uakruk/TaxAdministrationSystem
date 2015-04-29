package restful.Security;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This class used for:
 * checking permissions for every type of users
 *
 * important information:
 *
 * admin
 * user
 * audit
 * charger
 * registrator
 *
 * @author Yaroslav Kruk on 17.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public abstract class PermissionCheck {

    /*
    private static List<String> admins;
    private static List<String> users;
    private static List<String> KPR;
    private static List<String> audits;
    private static List<String> registrators;
    */
    private static HashMap<String, String> tokens;

    static {
        /*
        admins = new ArrayList<String>();
        users = new ArrayList<String>();
        KPR = new ArrayList<String>();
        audits = new ArrayList<String>();
        registrators = new ArrayList<String>();\
        */
        tokens = new HashMap<String, String>();
    }

    /**
     * check write permission by users token
     * @param token
     * @param section
     * @return
     * @throws PermissionException
     */
    public static boolean checkWrite(String token, String section) throws PermissionException {

        String status = tokens.get(token);
        if (section.equals("Audit")) {
            if (status.equals("admin") ||
                    status.equals("audit")) {
                return true;
            } else {
                throw new PermissionException();
            }
        } else if (section.equals("Charge")) {
            if (status.equals("admin") ||
                    status.equals("charger")) {
                return true;
            } else {
                throw new PermissionException();
            }
        } else if (section.equals("Registration")) {
            if (status.equals("admin") || status.equals("registrator")) {
                return true;
            } else {
                return false;
            }
        } else {
            throw new PermissionException();
        }
    }

    /**
     * check read permission by user's token
     * @param token
     * @param section
     * @return
     * @throws PermissionException
     */
    public static boolean checkRead(String token, String section) throws PermissionException {

        String status = tokens.get(token);
        if (section.equals("Audit")) {
            if (status.equals("user")) {
                throw new PermissionException();
            } else {
                return true;
            }
        } else if (section.equals("Charge")) {
            return true;
        } else if (section.equals("Registration")) {
            return true;
        } else {
            throw new PermissionException();
        }
    }


    /**
     * special cheking of permission to allow
     * common user add charges
     * @param token
     * @return
     * @throws PermissionException
     */
    public static boolean specialCheck(String token) throws PermissionException {
        String status = tokens.get(token);
        if (status.equals("admin") || status.equals("charger") ||
            status.equals("audit") || status.equals("user")) {
            return true;
        } else {
            throw new PermissionException();
        }
    }

    /**
     * associate token with user's right's
     * @param token
     * @param rights
     * @return
     */
    static String addToken(String token, String rights) {
        return tokens.put(token, rights);
    }

    /**
     * remove token from permissions collection
     * @param token
     * @return
     */
    static String removeToken(String token) {
        return tokens.remove(token);
    }
/*
    public static boolean addAdmin(String token) {
        return admins.add(token);
    }

    public static boolean deleteAdmin(String token) {
        return admins.remove(token);
    }
*/


}
