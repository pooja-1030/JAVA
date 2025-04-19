package P1;
import java.util.ArrayList;
import java.util.List;

public class ProductManagement {
    private List<String> products = new ArrayList<>();

    public void addProduct(String product) {
        products.add(product);
    }

    public List<String> getProducts() {
        return products;
    }
}
