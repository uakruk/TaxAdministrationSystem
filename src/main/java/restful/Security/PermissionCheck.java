package restful.Security;

import java.util.HashMap;
import java.util.List;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 17.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public abstract class PermissionCheck {

    private static HashMap<String, Boolean> permissions;

    static {
        permissions = new HashMap<String, Boolean>();
    }

    public static synchronized boolean check(String token) throws PermissionException {
        return true;
    }

    public static boolean hasFullAccess(String token) {
        return true;
    }

    public static boolean canRead(String token) {
        return true;
    }

    public static boolean hasAccessToAudit(String token) {
        return true;
    }

}
