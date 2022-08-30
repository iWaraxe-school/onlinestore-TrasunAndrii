package ua.issoft.store.threads;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import ua.issoft.domain.Product;
import ua.issoft.store.Store;

import java.util.concurrent.TimeUnit;

public class OrderExecutor implements Runnable {

    private final Store store;
    private final Product product;

    public OrderExecutor(Store store, Product product) {
        this.store = store;
        this.product = product;
    }

    @SneakyThrows
    @Override
    public void run() {
        int randomDelay = new Faker().number().numberBetween(1, 30);
        TimeUnit.SECONDS.sleep(randomDelay);
        store.addToOrderList(product);
    }
}
