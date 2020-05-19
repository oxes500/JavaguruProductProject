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

public class FindProductByNameServiceTest {

    @Mock
    private JPAProductRepository jpaProductRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findProductByNameSuccess() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.20), "milk for dinner");
        FindProductByNameService victim = new FindProductByNameService(jpaProductRepository);
        String productToFInd = "Milk";
        Mockito.when(jpaProductRepository.findByName(productToFInd)).thenReturn(Optional.of(product));
        Product actual = victim.findProductByName(productToFInd);
        assertEquals(actual, product);
    }

    @Test
    public void findProductByNameNotSuccess() {
        FindProductByNameService victim = new FindProductByNameService(jpaProductRepository);
        String productToFInd = "Milk";
        Mockito.when(jpaProductRepository.findByName(productToFInd)).thenReturn(Optional.empty());
        Product actual = victim.findProductByName(productToFInd);
        assertNull(actual);
    }
}