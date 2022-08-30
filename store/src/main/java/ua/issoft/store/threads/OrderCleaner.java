package ua.issoft.store.threads;

import lombok.SneakyThrows;
import ua.issoft.store.Store;

import java.util.TimerTask;

public class OrderCleaner extends TimerTask {

    private final Store store;

    public OrderCleaner(Store store) {
        this.store = store;
    }

    @SneakyThrows
    @Override
    public void run() {
        store.clearOrderList();
    }
}
