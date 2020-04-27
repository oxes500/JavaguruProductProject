package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.responses.AddProductResponse;
import lv.javaguru.finalwork.businesslogic.validation.ProductValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.ProductValidator;
import lv.javaguru.finalwork.businesslogic.validation.responses.UpdateProductResponse;
import lv.javaguru.finalwork.database.JPAProductListRepository;
import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.database.JPAUserRepository;
import lv.javaguru.finalwork.domain.Product;
import lv.javaguru.finalwork.domain.ProductList;
import lv.javaguru.finalwork.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class AddProductService {

   @Autowired private ProductValidator productValidator;
   @Autowired private JPAProductRepository jpaProductRepository;
   @Autowired private JPAProductListRepository jpaProductListRepository;
   @Autowired private JPAUserRepository jpaUserRepository;

   @Transactional
    public AddProductResponse addProduct(Product product, ProductList productList, User user) {
        ProductValidationResponse validationResponse = productValidator.validate(product);
        if (!validationResponse.isSuccess()) {
            return new AddProductResponse(false, validationResponse.getErrorMessages());
        }
        User userFromDb = jpaUserRepository.findByUsername(user.getUsername());
        jpaUserRepository.save(userFromDb);

        product.setProductList(productList);
        productList.setUser(userFromDb);

        jpaProductListRepository.save(productList);
        jpaProductRepository.save(product);
        return new AddProductResponse(true, null);
    }
}