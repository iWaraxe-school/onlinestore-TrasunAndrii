import org.reflections.Reflections;

import java.util.*;

public class StoreHelper {
    List<Category> categoryList;

    public List<Category> getCategoryList() {
        if (categoryList == null) {
            Reflections reflections = new Reflections();
            Set<Class<? extends Category>> subTypes = reflections.getSubTypesOf(Category.class);
            categoryList = new ArrayList<>();
            for (Class<? extends Category> classCat : subTypes) {
                try {
                    categoryList.add(classCat.newInstance());
                } catch (InstantiationException | IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return categoryList;
    }

    public Store randomFillStore(Store store) {
        categoryList = getCategoryList();
        RandomStorePopulator rsp = new RandomStorePopulator();
        for (Category category : categoryList) {
            for (int a = rsp.generateMaxProductAmount(); a > 0; a--) {
                category.addToList(rsp.generateRandomProduct(category.getName()));
            }
            store.addToList(category);
        }
        return store;
    }
}
