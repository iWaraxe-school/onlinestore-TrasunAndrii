package ua.issoft.domain;

public class Product {

    private String name;
    private int rate;
    private int price;

    public Product(String name, int rate, int price) {
        this.name = name;
        this.rate = rate;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "\"" + name + "\" (" + whatRate() +
                ") - " + whatPrice();
    }

    public int getRate() {
        return rate;
    }

    public int getPrice() {
        return price;
    }

    private String whatPrice() {
        StringBuilder sb = new StringBuilder(String.valueOf(getPrice()));
        sb.insert(sb.length() - 2, ".");
        sb.append(" USD");
        return sb.toString();
    }

    private String whatRate() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getRate(); i++) {
            sb.append("*");
        }
        return sb.toString();
    }
}
