package ua.issoft.store.consoleMenu;

public enum ConsoleCommands {
    SORT(1),
    TOP(2),
    QUIT(3);

    private final int value;

    ConsoleCommands(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
