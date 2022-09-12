package ua.issoft.consoleApp;

import ua.issoft.store.Store;
import ua.issoft.store.StoreHelper;
import ua.issoft.store.consoleMenu.ConsoleMenu;
import ua.issoft.store.http.Server;

public class StoreApp {

    public static void main(String[] args) {
        Store store = Store.getInstance();
        StoreHelper storeHelper = new StoreHelper();
        store = storeHelper.randomFillStoreViaDB(store);
        ConsoleMenu consoleMenu = new ConsoleMenu(store);
        Server server = Server.getInstance();
        server.startServer();
        consoleMenu.getStart();
    }
}
