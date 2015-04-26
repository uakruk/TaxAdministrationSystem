package restful.Security;

<<<<<<< HEAD
import java.util.HashMap;
import java.util.List;

=======
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
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

<<<<<<< HEAD
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

=======
    public static synchronized boolean check(String token) throws PermissionException {
        return true;
    }
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
}
