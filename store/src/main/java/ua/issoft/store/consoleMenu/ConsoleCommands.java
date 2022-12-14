package ua.issoft.store.consoleMenu;

public enum ConsoleCommands {
    SORT(1),
    TOP(2),
    ADD_RANDOM_PRODUCT_TO_ORDER(3),
    SHOW_ORDER_LIST(4),
    HTTP_POST_CART(5),
    HTTP_GET_CATEGORY(6),
    QUIT(9);

    private final int value;

    ConsoleCommands(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
