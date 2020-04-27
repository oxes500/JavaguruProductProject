package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.Assert.*;

public class FindProductByNameServiceTest {

    @InjectMocks private FindProductByIdService findProductByIdService;
    @Mock private JPAProductRepository jpaProductRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findProductByNameServiceSuccess() {
        Product product = new Product();
        FindProductByNameService victim = new FindProductByNameService(jpaProductRepository);
        Mockito.when(jpaProductRepository.findByName("product")).thenReturn(Optional.of(product));
        assertEquals(product, victim.findProductByName("product"));
    }

    @Test
    public void findProductByNameServiceNotSuccess() {
        FindProductByNameService victim = new FindProductByNameService(jpaProductRepository);
        Mockito.when(jpaProductRepository.findByName("product")).thenReturn(Optional.empty());
        assertNull(victim.findProductByName("product"));
    }

}