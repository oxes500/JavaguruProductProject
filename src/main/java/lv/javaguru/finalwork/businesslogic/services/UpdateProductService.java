package lv.javaguru.finalwork.businesslogic.services;

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
public class UpdateProductService {

    @Autowired private JPAProductRepository jpaProductRepository;
    @Autowired private JPAUserRepository jpaUserRepository;
    @Autowired private JPAProductListRepository jpaProductListRepository;

    public UpdateProductService(JPAProductRepository jpaProductRepository, JPAUserRepository jpaUserRepository, JPAProductListRepository jpaProductListRepository) {
        this.jpaProductRepository = jpaProductRepository;
        this.jpaUserRepository = jpaUserRepository;
        this.jpaProductListRepository = jpaProductListRepository;
    }

    @Transactional
    public UpdateProductResponse updateProduct(Product product) {

        Product productFromDb = jpaProductRepository.findById(product.getId()).get();
        ProductList productList = jpaProductListRepository.findById(productFromDb.getProductList().getId()).get();
        User user = jpaUserRepository.findById(productList.getUser().getId()).get();

        product.setId(product.getId());
        productList.setUser(user);
        product.setProductList(productList);
        jpaProductRepository.save(product);
        jpaProductListRepository.save(productList);
        jpaUserRepository.save(user);

        return new UpdateProductResponse(true, "Update is success!");
    }
}