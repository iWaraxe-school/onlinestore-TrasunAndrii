import org.reflections.Reflections;

import java.util.*;

public class StoreHelper {

    public static List<Category> getCategoryList() {
        Reflections reflections = new Reflections();
        Set<Class<? extends Category>> subTypes =
                reflections.getSubTypesOf(Category.class);
        List<Category> listCat = new ArrayList<>();
        for (Class<? extends Category> classCat : subTypes) {
            try {
                listCat.add(classCat.newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return listCat;
    }
}
