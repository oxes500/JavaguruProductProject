package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.domain.Category;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductCategorySwitcherServiceTest {

    @Test
    public void getCategory() {
        ProductCategorySwitcherService victim = new ProductCategorySwitcherService();
        assertEquals(victim.getCategory("0"), Category.NOT_APPLICABLE);
        assertEquals(victim.getCategory("1"), Category.VEGETABLE);
        assertEquals(victim.getCategory("2"), Category.FRUIT);
        assertEquals(victim.getCategory("3"), Category.BREAD);
        assertEquals(victim.getCategory("4"), Category.DRINK);
        assertEquals(victim.getCategory("5"), Category.MILK);
        assertEquals(victim.getCategory("6"), Category.MEAT);
        assertEquals(victim.getCategory("7"), Category.FISH);
    }
}