package ua.issoft.store;

public enum ConsoleCommands {
    SORT("sort"),
    TOP("top"),
    QUIT("quit");

    private final String value;

    ConsoleCommands(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
