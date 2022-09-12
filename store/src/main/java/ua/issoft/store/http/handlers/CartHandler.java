package ua.issoft.store.http.handlers;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import lombok.SneakyThrows;
import ua.issoft.domain.Product;
import ua.issoft.store.Store;
import ua.issoft.store.threads.OrderExecutor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class CartHandler implements HttpHandler {
    @SneakyThrows
    @Override
    public void handle(HttpExchange exchange) {
        String response = "Incorrect request method.";
        OutputStream os = exchange.getResponseBody();
        if (exchange.getRequestMethod().equalsIgnoreCase("POST")) {
            InputStreamReader inputStreamReader = new InputStreamReader(exchange.getRequestBody(), StandardCharsets.UTF_8);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String request = bufferedReader.readLine();
            Product product = new Gson().fromJson(request, Product.class);
            Store store = Store.getInstance();
            OrderExecutor orderExecutor = new OrderExecutor(store, product);
            new Thread(orderExecutor).start();
            response = "Success! Product will be soon in Order list.";
            exchange.sendResponseHeaders(200, response.length());
            os.write(response.getBytes());
        } else {
            exchange.sendResponseHeaders(401, response.length());
            os.write(response.getBytes());
        }
        os.close();
        exchange.close();
    }
}
