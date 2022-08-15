import java.util.List;

public class StoreApp {

    public static void main(String[] args) {
        Store store = new Store();

        List<Category> catList = StoreHelper.getCategoryList();
        for (Category cat : catList
        ) {
            for (int i = 0; i < 5; i++) {
                cat.addToList(RandomStorePopulator.generateRandomProduct(cat.getName()));
            }
            store.addToList(cat);
        }
        System.out.println(store);
    }
}
