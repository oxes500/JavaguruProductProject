package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class GetProductsByCategoryServiceTest {

    @Mock
    private JPAProductRepository jpaProductRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getProductsByCategory() {
        GetProductsByCategoryService victim = new GetProductsByCategoryService(jpaProductRepository);
        List<Product> products = new ArrayList<>();
        Product milk = new Product("Milk", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.20), "milk for dinner");
        Product potato = new Product("Potato", BigDecimal.valueOf(1.10), Category.VEGETABLE, BigDecimal.valueOf(0.10), "potato");
        products.add(milk);
        products.add(potato);
        List<Product> expected = new ArrayList<>();
        Product expectedMilk = new Product("Milk", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.20), "milk for dinner");
        expected.add(expectedMilk);
        Mockito.when(jpaProductRepository.findAll()).thenReturn(products);
        List<Product> actual = victim.getListByCategory(Category.MILK);
        verify(jpaProductRepository, times(1)).findAll();
        assertEquals(actual, expected);
    }
}