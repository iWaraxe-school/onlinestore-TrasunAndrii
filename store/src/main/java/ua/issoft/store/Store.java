package ua.issoft.store;

import ua.issoft.domain.Category;

import java.util.HashSet;
import java.util.Set;

public class Store {

    private final Set<Category> categorySet = new HashSet<>();

    private static Store instance;

    private Store() {
    }

    public static Store getInstance(){
        if(instance==null) {
        instance = new Store();
        }
        return instance;
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
}
