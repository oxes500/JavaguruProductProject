package FinalWork.database;

import FinalWork.domain.Product;

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

    public Product getProductByID(int id) {
        return products.get(id);
    }

    public boolean containsId(int id) {
        return id <= products.size();
    }

    public void removeProductById(int id) {
        products.remove(id);
        currentID--;
    }

    public boolean containsProducts() {
        return products.size() > 0;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void updateProduct(Product product) {
        Product updatedProduct = products.get(product.getId());
        updatedProduct.setName(product.getName());
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setDiscount(product.getDiscount());
        updatedProduct.setPrice(product.getPrice());
        products.add(product.getId(), updatedProduct);
    }
}