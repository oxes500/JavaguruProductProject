package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductPriceValidationRuleTest {

    @Test
    public void isValid() {
        Product product = new Product();
        ProductPriceValidationRule victim = new ProductPriceValidationRule();
        product.setPrice(BigDecimal.valueOf(10));
        assertTrue(victim.isValid(product));
        product.setPrice(BigDecimal.valueOf(0));
        assertFalse(victim.isValid(product));
        assertEquals(victim.errorMessage(), "Product price shouldn't be empty and should be greater than 0");
    }
}