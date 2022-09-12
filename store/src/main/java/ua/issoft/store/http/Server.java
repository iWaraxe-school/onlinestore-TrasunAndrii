package ua.issoft.store.http;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import lombok.SneakyThrows;
import ua.issoft.store.http.handlers.CartHandler;
import ua.issoft.store.http.handlers.CategoryHandler;

import java.net.InetSocketAddress;

public class Server {
    public static final int PORT = 8080;
    public static final String REALM = "store_realm";
    HttpServer server = null;

    private Server() {
    }

    private static class ServerHolder {
        private static final Server server = new Server();
    }

    public static Server getInstance() {
        return ServerHolder.server;
    }

    @SneakyThrows
    public void startServer() {
        server = HttpServer.create(new InetSocketAddress(PORT), 0);
        HttpContext contextCat = server.createContext("/categories", new CategoryHandler());
        HttpContext contextCart = server.createContext("/cart", new CartHandler());
        contextCat.setAuthenticator(new StoreAuthenticator(REALM));
        contextCart.setAuthenticator(new StoreAuthenticator(REALM));
        server.setExecutor(null);
        server.start();
    }

    public void stopServer() {
        server.stop(0);
    }
}
