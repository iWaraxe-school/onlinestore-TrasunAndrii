package ua.issoft.consoleApp;

import ua.issoft.store.Store;
import ua.issoft.store.StoreHelper;
import ua.issoft.store.consoleMenu.ConsoleMenu;

public class StoreApp {

    public static void main(String[] args) {
        Store store = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper();
        store = storeHelper.randomFillStore(store);
        store.print();
        ConsoleMenu consoleMenu = new ConsoleMenu(store);
        consoleMenu.autoCleaner();
        consoleMenu.getStart();
    }
}
