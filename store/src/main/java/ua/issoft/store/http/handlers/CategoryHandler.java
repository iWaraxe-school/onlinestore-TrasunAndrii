package ua.issoft.store.http.handlers;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import ua.issoft.domain.Category;
import ua.issoft.store.Store;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class CategoryHandler implements HttpHandler {
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        Gson gson = new Gson();
        StringBuilder sb = new StringBuilder();
        for (Category category : new ArrayList<>(Store.getInstance().getCategorySet())) {
            sb.append("[");
            sb.append(category.getName());
            sb.append("]");
        }
        byte[] response = gson.toJson(sb.toString()).getBytes();
        exchange.sendResponseHeaders(200, response.length);
        OutputStream os = exchange.getResponseBody();
        os.write(response);
        os.close();
        exchange.close();
    }
}
