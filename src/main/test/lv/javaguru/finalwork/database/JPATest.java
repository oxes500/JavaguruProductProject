
package lv.javaguru.finalwork.database;

import junit.framework.TestCase;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"/db/truncateTableProducts.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = {"/db/truncateTableProducts.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class JPATest extends TestCase {

    @Autowired
    private JPAProductRepository productRepository;

    @Test
    public void addProduct() {
        Product product = new Product("TestProductAddProductTest", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.2), "nice milk");
        assertNull(product.getId());
        productRepository.save(product);
        assertNotNull(product.getId());
        assertTrue(productRepository.findById(product.getId()).isPresent());
    }

    @Test
    public void findById() {
        Product product = new Product("TestProductAddProductTest", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.2), "nice milk");
        productRepository.save(product);
        Long productId = product.getId();
        assertTrue(productRepository.findById(productId).isPresent());
    }

}