/*
package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.SpringConfig;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })

@SqlGroup({
        @Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD, scripts = "classpath:truncateTableProducts.sql")
})

@TransactionConfiguration(defaultRollback = false)
public class JDBCProductRepositoryTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    @Transactional
    public void addProduct() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.20), Category.MILK, BigDecimal.valueOf(0.20), "1l_Pack");
        assertNull(product.getId());
        productRepository.addProduct(product);
        assertNotNull(product.getId());
    }

    @Transactional
    @Test
    public void getProducts() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.20), Category.MILK, BigDecimal.valueOf(0.20), "1l_Pack");
        productRepository.addProduct(product);
        List<Product> products = productRepository.getProducts();
        assertFalse(products.isEmpty());
    }

    @Transactional
    @Test
    public void findProductById() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.20), Category.MILK, BigDecimal.valueOf(0.20), "1l_Pack");
        productRepository.addProduct(product);
        Optional<Product> foundProduct = productRepository.findById(product.getId());
        assertTrue(foundProduct.isPresent());
    }

    @Transactional
    @Test
    public void deleteProductById() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.20), Category.MILK, BigDecimal.valueOf(0.20), "1l_Pack");
        productRepository.addProduct(product);
        boolean isDeleted = productRepository.deleteById(product.getId());
        assertTrue(isDeleted);
    }

    @Transactional
    @Test
    public void getProductsByCategory() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.20), Category.MILK, BigDecimal.valueOf(0.20), "1l_Pack");
        productRepository.addProduct(product);
        List<Product> products = productRepository.getProductByCategory(Category.MILK);
        assertFalse(products.isEmpty());
    }

    @Transactional
    @Test
    public void findProductByName() {
        Product product = new Product("potato", BigDecimal.valueOf(1.20), Category.MILK, BigDecimal.valueOf(0.20), "1l_Pack");
        productRepository.addProduct(product);
        Optional<Product> foundProduct = productRepository.findProductByName("potato");
        assertTrue(foundProduct.isPresent());
    }
    
    @Transactional
    @Test
    public void updateProduct() {
        Product product = new Product("Potato", BigDecimal.valueOf(1.00), Category.VEGETABLE, BigDecimal.valueOf(0.20), "1kg");
        productRepository.addProduct(product);
        Product updatedProduct = new Product("milk", BigDecimal.valueOf(1.11), Category.MILK, BigDecimal.valueOf(0.10), "1L");
        updatedProduct.setId(product.getId());
        productRepository.updateProduct(updatedProduct);
        assertNotEquals(product, productRepository.findById(updatedProduct.getId()).get());
    }
}*/
