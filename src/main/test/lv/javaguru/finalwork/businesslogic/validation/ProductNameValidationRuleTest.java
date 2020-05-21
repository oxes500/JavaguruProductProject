package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Product;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class ProductNameValidationRuleTest {

    @Test
    public void isValid() {
        Product product = new Product();
        ProductNameValidationRule victim = new ProductNameValidationRule();
        product.setName("Milk");
        assertTrue(victim.isValid(product));
        product.setName("");
        assertFalse(victim.isValid(product));
        product.setName("a");
        assertFalse(victim.isValid(product));
        product.setName("1234567890123456789012345678901234567890");
        assertFalse(victim.isValid(product));
        assertEquals(victim.errorMessage(), "Product name shouldn't be empty and this length should be from 3 to 32 symbols!");
    }
}