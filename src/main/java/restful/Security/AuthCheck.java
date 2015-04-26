package restful.Security;

<<<<<<< HEAD
import java.util.*;

=======
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
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

<<<<<<< HEAD
    private static List<String> tokens;
    private static Iterator<String> iter;

    static {
        tokens = new ArrayList<String>();
    }

    public static boolean check(String token) throws AuthSecurityException {
        if (!tokens.contains(token)) {
=======
    public static boolean check(String token) throws AuthSecurityException {
        if (!token.equals(null)) {
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
            throw new AuthSecurityException();
        }
        return true;
    }
<<<<<<< HEAD

    static void addToken(String token) {
        tokens.add(token);
    }

    static boolean removeToken(String token) {
        return tokens.remove(token);
    }


=======
>>>>>>> 3179ac4f6421a9cff17b67e34c6df598ab89ace3
}
