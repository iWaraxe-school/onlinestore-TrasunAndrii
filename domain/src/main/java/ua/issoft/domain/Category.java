package ua.issoft.domain;

import java.util.HashSet;
import java.util.Set;

public abstract class Category {

    final private String name;
    protected Set<Product> productSet = new HashSet<>();

    public String getName() {
        return name;
    }

    public Category(String name) {
        this.name = name;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("(Category): ");
        for (Product product: productSet) {
            sb.append("\n");
            sb.append(product.toString());
        }
        return sb.toString();
    }

    public void addToList(Product product) {
        productSet.add(product);
    }
}
