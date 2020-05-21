package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductCategoryValidationRuleTest {

    @Test
    public void isValid() {
        Product product = new Product();
        ProductCategoryValidationRule victim = new ProductCategoryValidationRule();
        product.setCategory(Category.BREAD);
        assertTrue(victim.isValid(product));
        product.setCategory(Category.FRUIT);
        assertTrue(victim.isValid(product));
        product.setCategory(Category.DRINK);
        assertTrue(victim.isValid(product));
        product.setCategory(Category.MILK);
        assertTrue(victim.isValid(product));
        product.setCategory(Category.MEAT);
        assertTrue(victim.isValid(product));
        product.setCategory(Category.FISH);
        assertTrue(victim.isValid(product));
        product.setCategory(Category.NOT_APPLICABLE);
        assertTrue(victim.isValid(product));
        product.setCategory(null);
        assertFalse(victim.isValid(product));
        assertEquals(victim.errorMessage(), "Please enter valid number of Category");
    }

}