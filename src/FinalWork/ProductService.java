package FinalWork;

import java.util.List;

public class ProductService {

    private ProductDatabase database;

    public ProductService(ProductDatabase database) {
        this.database = database;
    }

    public ProductResponse addProduct(Product product) {
        if (product.getName() == null
            || product.getName().equals("")) {
            return new ProductResponse(false, "Empty product name!");
        }
        database.addProduct(product);
        return new ProductResponse(true, null);
    }

    public Product getProductById(int id) {
        return database.getProductByID(id - 1);
    }

    public List<Product> getProductList() {
        return database.getProducts();
    }

    public ProductResponse removeProductByID(Integer id) {
        if (id != null && dbContainsId(id)) {
            database.removeProductById(id);
            return new ProductResponse(true, null);
        }
        return new ProductResponse(false, "ID is not found in the list");
    }

    public boolean dbIsNotEmpty() {
        return database.databaseNotEmpty();
    }

    public boolean dbContainsId(Integer id) {
        return database.containsId(id);
    }
}
