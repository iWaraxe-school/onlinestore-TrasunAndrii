import java.util.ArrayList;
import java.util.List;

public class Category {

    final private String name;
    protected List<Product> productList = new ArrayList<>();

    public String getName() {
        return name;
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName());
        sb.append("(Category): ");
        for (Product product:productList) {
            sb.append("\n");
            sb.append(product.toString());
        }
        return sb.toString();
    }

    public void addToList(Product product) {
        productList.add(product);
    }
}
