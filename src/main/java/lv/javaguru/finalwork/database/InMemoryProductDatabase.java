package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.domain.Product;

import java.util.ArrayList;
import java.util.List;

//@Component
public class InMemoryProductDatabase {
    private Long currentID = 1L;
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        product.setId(currentID);
        products.add(product);
        this.currentID++;
    }

    public Product getProductByID(int id) {
        return products.get(id);
    }

    public boolean containsId(Long id) {
        return id <= products.size();
    }

    public void removeProductById(Long id) {
        products.remove(id);
        currentID--;
    }

    public boolean containsProducts() {
        return products.size() > 0;
    }

    public List<Product> getProducts() {
        return products;
    }

/*    public void updateProduct(Product product) {
        Product updatedProduct = products.get(product.getId());
        updatedProduct.setName(product.getName());
        updatedProduct.setCategory(product.getCategory());
        updatedProduct.setDescription(product.getDescription());
        updatedProduct.setDiscount(product.getDiscount());
        updatedProduct.setPrice(product.getPrice());
        products.add(product.getId(), updatedProduct);
    }*/
}