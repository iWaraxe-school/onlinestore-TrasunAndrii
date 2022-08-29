package ua.issoft.store.consoleMenu;

import ua.issoft.store.Store;

import static ua.issoft.store.constants.GlobalConstant.MENU_SORT_TEXT;

public class SortedStateMenu extends StateMenu {

    public SortedStateMenu(ConsoleMenu consoleMenu, Store store) {
        super(consoleMenu, store);
    }

    @Override
    public void showMenu() {
        System.out.println(MENU_SORT_TEXT);
        runCommand();
    }
}

