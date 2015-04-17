package restful.Security;

/**
 * This class used for:
 *
 * @author Yaroslav Kruk on 14.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public abstract class AuthCheck {

    public static boolean check(String token) throws AuthSecurityException {
        if (!token.equals(null)) {
            throw new AuthSecurityException();
        }
        return true;
    }
}
