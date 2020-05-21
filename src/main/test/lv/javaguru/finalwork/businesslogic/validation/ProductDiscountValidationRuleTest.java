package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductDiscountValidationRuleTest {

    @Test
    public void isValid() {
        Product product = new Product();
        ProductDiscountValidationRule victim = new ProductDiscountValidationRule();
        product.setDiscount(BigDecimal.valueOf(0.10));
        assertTrue(victim.isValid(product));
        product.setDiscount(BigDecimal.valueOf(10));
        assertFalse(victim.isValid(product));
        product.setDiscount(BigDecimal.valueOf(0));
        assertFalse(victim.isValid(product));
        product.setDiscount(BigDecimal.valueOf(-10));
        assertFalse(victim.isValid(product));
        assertEquals(victim.errorMessage(), "Product discount should be between 1 and 100% (0.01 till 1.00)");
    }
}