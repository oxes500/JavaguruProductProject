/*
package lv.javaguru.finalwork.database;

import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import lv.javaguru.finalwork.domain.ProductList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@DataJpaTest
@Rollback(value = false)
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
@Sql(scripts = {"/db/truncateTableProducts.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = {"/db/truncateTableProducts.sql"}, executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)

public class JPAProductListReposiroryTest {

    @Autowired
    private JPAProductListRepository productListRepository;

    @Autowired
    private JPAProductRepository productRepository;

    @Test
    @Transactional
    public void createProductList() {
        ProductList productList = new ProductList("Partika", "MorningShoping");
        productListRepository.save(productList);

        Product product = new Product("Potato", BigDecimal.valueOf(1.00), Category.VEGETABLE, BigDecimal.valueOf(0.20), "1kg");
        product.setProductList(productList);
        productRepository.save(product);
    }



}
*/
