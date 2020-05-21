package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.responses.UpdateProductResponse;
import lv.javaguru.finalwork.database.JPAProductListRepository;
import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.database.JPAUserRepository;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import lv.javaguru.finalwork.domain.ProductList;
import lv.javaguru.finalwork.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;
import java.math.BigDecimal;
import java.util.Optional;

public class UpdateProductServiceTest {

    @Mock
    private JPAProductRepository jpaProductRepository;
    @Mock
    private JPAUserRepository jpaUserRepository;
    @Mock
    private JPAProductListRepository jpaProductListRepository;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void updateProductTest() {
        Product product = new Product("Milk", BigDecimal.valueOf(1.00), Category.MILK, BigDecimal.valueOf(0.20), "milk for dinner");
        ProductList productList = new ProductList("MilkProducts", "MilkProducts");
        User user = new User("alex", "serg");
        product.setProductList(productList);
        productList.setUser(user);
        Mockito.when(jpaProductRepository.findById(product.getId())).thenReturn(Optional.of(product));
        Mockito.when(jpaProductListRepository.findById(product.getProductList().getId())).thenReturn(Optional.of(productList));
        Mockito.when(jpaUserRepository.findById(productList.getUser().getId())).thenReturn(Optional.of(user));
        UpdateProductService victim = new UpdateProductService(jpaProductRepository, jpaUserRepository, jpaProductListRepository);
        UpdateProductResponse actual = victim.updateProduct(product);
        assertTrue(actual.isSuccess());
        assertEquals(actual.getErrorMessage(), "Update is success!");
    }
}