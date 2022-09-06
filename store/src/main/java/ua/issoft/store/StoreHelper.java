package ua.issoft.store;

import org.reflections.Reflections;
import ua.issoft.domain.Category;
import ua.issoft.domain.Product;
import ua.issoft.store.dataBase.DataBase;
import ua.issoft.store.helpers.ProductComparator;

import java.util.*;

import static ua.issoft.store.constants.GlobalConstant.CONFIG_XML;
import static ua.issoft.store.constants.GlobalConstant.TOP5_XML;

public class StoreHelper {
    Set<Category> categorySet;

    public Set<Category> getCategorySet() {
        if (categorySet == null) {
            Reflections reflections = new Reflections();
            Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);
            categorySet = new HashSet<>();
            for (Class<? extends Category> classCat : subTypes) {
                try {
                    categorySet.add(classCat.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return categorySet;
    }

    public Store randomFillStore(Store store) {
        categorySet = getCategorySet();
        RandomStorePopulator rsp = new RandomStorePopulator();
        for (Category category : categorySet) {
            for (int a = rsp.generateMaxProductAmount(); a > 0; a--) {
                category.addToList(rsp.generateRandomProduct(category.getName()));
            }
            store.addToSet(category);
        }
        return store;
    }
    public Store randomFillStoreViaDB(Store store) {
        DataBase dataBase = new DataBase();
        return dataBase.getStoreFromDB(store);
    }
    private Set<Product> getProductSet (Store store){
        Set<Product> tempProdSet = new HashSet<>();
        Set<Category> storeCategorySet = store.getCategorySet();
        for (Category category :storeCategorySet){
            Set<Product> productSet = category.getProductSet();
            tempProdSet.addAll(productSet);
        }
        return tempProdSet;
    }
    public void printSort (Store store) {
        ProductComparator productComparator = new ProductComparator(CONFIG_XML);
        Set<Product> tempProdSet = getProductSet(store);
        tempProdSet.stream().sorted(productComparator).forEach(System.out::println);

    }
    public void printTop5 (Store store){
        ProductComparator productComparator = new ProductComparator(TOP5_XML);
        Set<Product> tempProdSet = getProductSet(store);
        tempProdSet.stream().sorted(productComparator).limit(5).forEach(System.out::println);
    }
}
