package ua.issoft.store.consoleMenu;

import ua.issoft.store.Store;

import static ua.issoft.store.constants.GlobalConstant.MENU_WELCOME;

public class ConsoleMenu {

    private StateMenu stateMenu;
    private final Store store;

    public ConsoleMenu(Store store) {
        this.store = store;
    }

    public StateMenu getStateMenu() {
        return stateMenu;
    }

    public void setStateMenu(StateMenu stateMenu) {
        this.stateMenu = stateMenu;
    }

    public void getStart(){
        System.out.println(MENU_WELCOME);
        this.stateMenu = new DefaultStateMenu(this, store);
        this.getStateMenu().showMenu();
    }
}
