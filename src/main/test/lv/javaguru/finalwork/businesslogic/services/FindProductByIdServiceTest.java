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

public class FindProductByIdServiceTest {

    @InjectMocks private FindProductByIdService findProductByIdService;
    @Mock private JPAProductRepository jpaProductRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void findProductByIdServiceSuccess() {
        Product product = new Product();
        FindProductByIdService victim = new FindProductByIdService(jpaProductRepository);
        Mockito.when(jpaProductRepository.findById(1L)).thenReturn(Optional.of(product));
        assertEquals(product, victim.findProductById(1L));
    }

    @Test
    public void findProductByIdServiceNotSuccess() {
        FindProductByIdService victim = new FindProductByIdService(jpaProductRepository);
        Mockito.when(jpaProductRepository.findById(1L)).thenReturn(Optional.empty());
        assertNull(victim.findProductById(1L));
    }
}
