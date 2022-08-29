package ua.issoft.store.consoleMenu;

import ua.issoft.store.Store;

import static ua.issoft.store.constants.GlobalConstant.MENU_DEFAULT_TEXT;


public class DefaultStateMenu extends StateMenu {

    public DefaultStateMenu(ConsoleMenu consoleMenu, Store store) {
        super(consoleMenu, store);
    }

    @Override
    public void showMenu() {
        System.out.println(MENU_DEFAULT_TEXT);
        runCommand();
    }
}
