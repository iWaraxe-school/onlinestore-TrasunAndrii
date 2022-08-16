
import java.util.ArrayList;
import java.util.List;

public class Store {

    private final List<Category> categoryList = new ArrayList<>();

    public void addToList(Category category) {
        categoryList.add(category);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Store [");
        for (Category category : categoryList) {
            sb.append("\n");
            sb.append(category.toString());
        }
        return sb.append("\n]").toString();
    }

    public void print() {
        System.out.println(this);
    }
}
