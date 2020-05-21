package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductDescriptionValidationRuleTest {

    @Test
    public void isValid() {
        Product product = new Product();
        ProductDescriptionValidationRule victim = new ProductDescriptionValidationRule();
        product.setDescription("Description");
        assertTrue(victim.isValid(product));
        product.setDescription("");
        assertFalse(victim.isValid(product));
        product.setDescription(null);
        assertFalse(victim.isValid(product));
        product.setDescription("12345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901");
        assertFalse(victim.isValid(product));
        assertEquals(victim.errorMessage(), "Product description length should be from 1 to 100 symbols");
    }
}