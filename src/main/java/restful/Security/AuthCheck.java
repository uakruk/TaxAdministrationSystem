package restful.Security;

import java.util.*;

/**
 * This class used for:
 * cheking the authentification of user
 * @author Yaroslav Kruk on 14.04.15.
 *         e-mail : uakruk@ukr.net
 *         GitHub : https://github.com/uakruk
 * @version 1.0
 * @since 1.7
 */
public abstract class AuthCheck {

    private static List<String> tokens;
    private static Iterator<String> iter;

    static {
        tokens = new ArrayList<String>();
    }

    /**
     * check whether a user already logged in
     * @param token
     * @return
     * @throws AuthSecurityException
     */
    public static boolean check(String token) throws AuthSecurityException {
        if (!tokens.contains(token)) {
            throw new AuthSecurityException();
        }
        return true;
    }

    /**
     * service method. add new token to collection
     * @param token
     */
    static void addToken(String token) {
        tokens.add(token);
    }

    /**
     * service method. remove a token from collection
     * @param token
     * @return
     */
    static boolean removeToken(String token) {
        return tokens.remove(token);
    }


}
