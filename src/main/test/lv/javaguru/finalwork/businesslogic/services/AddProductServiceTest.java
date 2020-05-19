package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.ProductValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.ProductValidator;
import lv.javaguru.finalwork.businesslogic.validation.responses.AddProductResponse;
import lv.javaguru.finalwork.database.JPAProductListRepository;
import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.database.JPAUserRepository;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import lv.javaguru.finalwork.domain.ProductList;
import lv.javaguru.finalwork.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class AddProductServiceTest {

   @InjectMocks private AddProductService addProductService;
   @Mock private ProductValidator productValidator;
   @Mock private JPAProductRepository productRepository;
   @Mock private JPAUserRepository userRepository;
   @Mock private JPAProductListRepository productListRepository;

   @Before
   public void setUp() {
       MockitoAnnotations.initMocks(this);
   }

   @Test
   public void addProductServiceTestValidatedProduct(){
       Product product = new Product("Milk", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.20), "milk for dinner");
       ProductList productList = new ProductList("MilkProducts", "MilkProducts");
       User user = new User("alex", "serg");
       product.setProductList(productList);
       productList.setUser(user);
       AddProductService victim = new AddProductService(productValidator, productRepository, productListRepository, userRepository);
       Mockito.when(productValidator.validate(product)).thenReturn(new ProductValidationResponse(true, null));
       victim.addProduct(product);
       verify(productRepository, times(1)).save(product);
       Mockito.when(victim.addProduct(product)).thenReturn(new AddProductResponse(true, null));
       assertTrue(victim.addProduct(product).isSuccess());
       assertNull(victim.addProduct(product).getErrorMessages());
   }

    @Test
    public void addProductServiceTestNotValidatedProduct(){
        Product product = new Product("Milk", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.20), "milk for dinner");
        AddProductService victim = new AddProductService(productValidator, productRepository, productListRepository, userRepository);
        Mockito.when(productValidator.validate(product)).thenReturn(new ProductValidationResponse(false, null));
        victim.addProduct(product);
        verify(productRepository, times(0)).save(product);
        assertFalse(victim.addProduct(product).isSuccess());
        assertNull(victim.addProduct(product).getErrorMessages());
    }
}