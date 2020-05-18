package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    void addProduct(Product product);

    List<Product> getProducts();

    Optional<Product> findById(Long id);

    boolean deleteById(Long id);

    List<Product> getProductByCategory(Category category);

    Optional<Product> findProductByName(String productName);

    void updateProduct(Product product);

}
