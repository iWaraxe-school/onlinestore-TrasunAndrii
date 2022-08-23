package ua.issoft.consoleApp;

import ua.issoft.store.ConsoleMenu;
import ua.issoft.store.Store;
import ua.issoft.store.StoreHelper;

public class StoreApp {

    public static void main(String[] args) {
        Store store = new Store();
        StoreHelper storeHelper = new StoreHelper();
        store = storeHelper.randomFillStore(store);
        ConsoleMenu.getStart(store);
    }
}
