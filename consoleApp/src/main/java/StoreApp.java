public class StoreApp {

    public static void main(String[] args) {
        Store store = new Store();
        StoreHelper storeHelper = new StoreHelper();
        store = storeHelper.randomFillStore(store);
        store.print();
    }
}
