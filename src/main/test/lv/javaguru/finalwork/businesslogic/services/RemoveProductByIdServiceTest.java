package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class RemoveProductByIdServiceTest {

    @Mock
    private JPAProductRepository jpaProductRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void removeUser() {
        RemoveProductByIdService victim = new RemoveProductByIdService(jpaProductRepository);
        Long id = 10L;
        boolean actual = victim.removeProductById(id);
        verify(jpaProductRepository, times(1)).deleteById(id);
        assertTrue(actual);
    }
}