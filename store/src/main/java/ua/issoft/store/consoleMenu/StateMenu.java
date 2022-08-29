package ua.issoft.store.consoleMenu;

import ua.issoft.store.Store;
import ua.issoft.store.StoreHelper;

import java.util.Scanner;

import static ua.issoft.store.constants.GlobalConstant.MENU_CONFIRM_TEXT;
import static ua.issoft.store.constants.GlobalConstant.MENU_WARNING_MESSAGE;

public abstract class StateMenu {

    private final Scanner scanner = new Scanner(System.in);
    private final StoreHelper storeHelper = new StoreHelper();

    protected ConsoleMenu consoleMenu;

    protected Store store;

    public StateMenu(ConsoleMenu consoleMenu, Store store) {
        this.consoleMenu = consoleMenu;
        this.store = store;
    }

    abstract void showMenu();

    int readConsoleCommand() {
        return scanner.nextInt();
    }

    boolean verifyCommand(int command) {
        int commLength = ConsoleCommands.values().length;
        return command <= commLength && command != getNumberStateMenu();
    }

    int getNumberStateMenu() {
        if (this instanceof SortedStateMenu) {
            return 1;
        } else if (this instanceof TopStateMenu) {
            return 2;
        }
        return 0;
    }

    void runCommand() {
        firstPoint:
        {
            int command = readConsoleCommand();
            if (verifyCommand(command)) {
                switch (command) {
                    case 1:
                        System.out.println("Start sorting...");
                        storeHelper.printSort(store);
                        consoleMenu.setStateMenu(new SortedStateMenu(consoleMenu, store));
                        break;
                    case 2:
                        System.out.println("Top 5 products:");
                        storeHelper.printTop5(store);
                        consoleMenu.setStateMenu(new TopStateMenu(consoleMenu, store));
                        break;

                    case 3:
                        if (confirmCommand()) {
                            System.out.println("Goodbye...");
                            break firstPoint;
                        }
                        break;
                }
            } else printWarningMessage();
            consoleMenu.getStateMenu().showMenu();
        }
    }

    boolean confirmCommand() {
        System.out.println(MENU_CONFIRM_TEXT);
        int command = readConsoleCommand();
        switch (command) {
            case 1:
                return true;
            case 2:
                break;
            default:
                printWarningMessage();
        }
        return false;
    }


    void printWarningMessage() {
        System.out.println(MENU_WARNING_MESSAGE);
    }
}
