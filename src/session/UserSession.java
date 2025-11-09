
package session;

public class UserSession {

    private static String email;
    private static String role;

    private UserSession() {}

    public static void setUser(String email, String role) {
        UserSession.email = email;
        UserSession.role = role;
    }

    public static String getEmail() {
        return email;
    }

    public static String getRole() {
        return role;
    }

    public static void clearSession() {
        email = null;
        role = null;
    }
}
