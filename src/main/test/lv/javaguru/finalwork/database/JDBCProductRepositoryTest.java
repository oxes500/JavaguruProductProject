package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.SpringConfig;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:cleanAllTables.sql")
})

public class JDBCProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void addProduct() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.20), Category.MILK, BigDecimal.valueOf(0.20), "1l_Pack");
        assertNull(product.getId());
        productRepository.addProduct(product);
        assertNotNull(product.getId());
    }

    @Test
    public void getProducts() {
        List<Product> products = productRepository.getProducts();
        assertFalse(products.isEmpty());
    }

    @Test
    public void findProductById() {
        Optional<Product> foundProduct = productRepository.findById(1002);
        assertFalse(foundProduct.isPresent());
    }

    @Test
    public void deleteProductById() {
        boolean isDeleted = productRepository.deleteById(1002);
        assertTrue(isDeleted);
    }

    @Test
    public void getProductsByCategory() {
        List<Product> products = productRepository.getProductByCategory(Category.BREAD);
        assertTrue(products.isEmpty());
    }

    @Test
    public void findProductByName() {
        Optional<Product> foundProduct = productRepository.findProductByName("milk");
        assertTrue(foundProduct.isPresent());
    }

    @Test
    public void updateProduct() {
        Product product = new Product("Potato", BigDecimal.valueOf(1.00), Category.VEGETABLE, BigDecimal.valueOf(0.20), "1kg");
        productRepository.addProduct(product);
        Product updatedProduct = new Product("milk", BigDecimal.valueOf(1.11), Category.MILK, BigDecimal.valueOf(0.10), "1L");
        updatedProduct.setId(product.getId());
        productRepository.updateProduct(updatedProduct);
        assertNotEquals(product, productRepository.findById(updatedProduct.getId()).get());
    }
}