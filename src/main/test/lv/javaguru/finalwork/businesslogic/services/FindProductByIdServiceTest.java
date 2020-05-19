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
import java.util.Optional;

import static org.junit.Assert.*;

public class FindProductByIdServiceTest {

    @Mock private JPAProductRepository jpaProductRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findProductByIdSuccess() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.20), "milk for dinner");
        FindProductByIdService victim = new FindProductByIdService(jpaProductRepository);
        Long numberToFind = 10L;
        Mockito.when(jpaProductRepository.findById(numberToFind)).thenReturn(Optional.of(product));
        Product actual = victim.findProductById(numberToFind);
        assertEquals(actual, product);
    }

    @Test
    public void findProductByIdNotSuccess() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.20), "milk for dinner");
        FindProductByIdService victim = new FindProductByIdService(jpaProductRepository);
        Long numberToFind = 10L;
        Mockito.when(jpaProductRepository.findById(numberToFind)).thenReturn(Optional.empty());
        Product actual = victim.findProductById(numberToFind);
        assertNull(actual);
    }
}