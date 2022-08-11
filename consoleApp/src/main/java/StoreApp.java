
public class StoreApp {

    public static void main(String[] args) {
        Store store = new Store();
        Category categoryBeer = new Category("Beer");
        categoryBeer.addToList(RandomStorePopulator.generateRandomProduct(categoryBeer.getName()));
        categoryBeer.addToList(RandomStorePopulator.generateRandomProduct(categoryBeer.getName()));
        categoryBeer.addToList(RandomStorePopulator.generateRandomProduct(categoryBeer.getName()));
        Category categoryFood = new Category("Food");
        categoryFood.addToList(RandomStorePopulator.generateRandomProduct(categoryFood.getName()));
        categoryFood.addToList(RandomStorePopulator.generateRandomProduct(categoryFood.getName()));
        categoryFood.addToList(RandomStorePopulator.generateRandomProduct(categoryFood.getName()));
        store.addToList(categoryBeer);
        store.addToList(categoryFood);
        System.out.println(store);

        StoreHelper.getCategoryList().forEach(category1 -> System.out.println(category1.getName()));
    }
}
