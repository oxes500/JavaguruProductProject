/*
package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.ProductValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.ProductValidator;
import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.database.ProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AddProductServiceTest {

   @InjectMocks private AddProductService addProductService;
   @Mock private ProductValidator productValidator;
   @Mock private JPAProductRepository productRepository;

   @Before
   public void setUp() {
       MockitoAnnotations.initMocks(this);
   }

   @Test
   public void addProductServiceTestValidatedProduct(){
       Product product = new Product();
       AddProductService victim = new AddProductService(productRepository, productValidator);
       Mockito.when(productValidator.validate(product)).thenReturn(new ProductValidationResponse(true, null));
       victim.addProduct(product);
       verify(productRepository, times(1)).save(product);
       assertTrue(victim.addProduct(product).isSuccess());
       assertNull(victim.addProduct(product).getErrorMessages());
   }

    @Test
    public void addProductServiceTestNotValidatedProduct(){
        Product product = new Product();
        AddProductService victim = new AddProductService(productRepository, productValidator);
        Mockito.when(productValidator.validate(product)).thenReturn(new ProductValidationResponse(false, null));
        victim.addProduct(product);
        verify(productRepository, times(0)).save(product);
        assertFalse(victim.addProduct(product).isSuccess());
        assertNull(victim.addProduct(product).getErrorMessages());
    }
}
*/
