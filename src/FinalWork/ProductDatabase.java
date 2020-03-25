package FinalWork;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private int currentID = 1;
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        product.setId(currentID);
        products.add(product);
        this.currentID++;
    }

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductByID(int id) {
        return products.get(id);
    }

    public void removeProductById(int id) {
        products.remove(id);
    }

    public boolean containsId(Integer id) {
        return products.size() >= id;
    }

    public boolean databaseNotEmpty() {
        return products.size() > 0;
    }

}