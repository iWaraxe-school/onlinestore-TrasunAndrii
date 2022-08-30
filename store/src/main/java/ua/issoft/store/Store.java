package ua.issoft.store;

import ua.issoft.domain.Category;
import ua.issoft.domain.Product;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Store {

    private final Set<Category> categorySet = new HashSet<>();
    private final BlockingQueue<Product> orderList = new LinkedBlockingQueue<>();

    private Store() {
    }

    private static class StoreHolder {
        private static final Store store = new Store();
    }

    public static Store getInstance() {
        return StoreHolder.store;
    }

    public void addToSet(Category category) {
        categorySet.add(category);
    }

    public Set<Category> getCategorySet() {
        return categorySet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Store [");
        for (Category category : categorySet) {
            sb.append("\n");
            sb.append(category.toString());
        }
        return sb.append("\n]").toString();
    }

    public void print() {
        System.out.println(this);
    }

    public void printOrderList() {
        if (orderList.isEmpty()) {
            System.out.println("Order list is empty");
        } else
            System.out.println(orderList);
    }

    public void addToOrderList(Product product) {
        orderList.add(product);
    }

    public void clearOrderList() {
        orderList.clear();
    }
}
