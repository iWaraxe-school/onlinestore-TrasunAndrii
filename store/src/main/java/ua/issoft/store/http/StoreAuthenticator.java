package ua.issoft.store.http;

import com.sun.net.httpserver.BasicAuthenticator;

public class StoreAuthenticator extends BasicAuthenticator {
    private static final String USER = "admin";
    private static final String PASSWORD = "password";

    public StoreAuthenticator(String realm) {
        super(realm);
    }

    @Override
    public boolean checkCredentials(String user, String password) {
        return user.equals(USER) && password.equals(PASSWORD);
    }
}
