package ua.issoft.store.consoleMenu;

import ua.issoft.store.Store;

import static ua.issoft.store.constants.GlobalConstant.MENU_TOP_TEXT;

public class TopStateMenu extends StateMenu {

    public TopStateMenu(ConsoleMenu consoleMenu, Store store) {
        super(consoleMenu, store);
    }

    @Override
    public void showMenu() {
        System.out.println(MENU_TOP_TEXT);
        runCommand();
    }
}
