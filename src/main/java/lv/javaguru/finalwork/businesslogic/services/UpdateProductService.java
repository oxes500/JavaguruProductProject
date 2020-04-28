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

    private JPAProductRepository jpaProductRepository;
    private JPAUserRepository jpaUserRepository;
    private JPAProductListRepository jpaProductListRepository;

    @Autowired
    public UpdateProductService(JPAProductRepository jpaProductRepository, JPAUserRepository jpaUserRepository, JPAProductListRepository jpaProductListRepository) {
        this.jpaProductRepository = jpaProductRepository;
        this.jpaUserRepository = jpaUserRepository;
        this.jpaProductListRepository = jpaProductListRepository;
    }

    @Transactional
    public UpdateProductResponse updateProduct(Product product) {

        Long id = product.getId();
        Product productFromDb = jpaProductRepository.findById(id).get();
        ProductList productList = jpaProductListRepository.findById(productFromDb.getProductList().getId()).get();
        User user = jpaUserRepository.findById(productList.getUser().getId()).get();

        product.setId(id);
        productList.setUser(user);
        product.setProductList(productList);
        jpaProductRepository.save(product);
        jpaProductListRepository.save(productList);
        jpaUserRepository.save(user);

        return new UpdateProductResponse(true, "Update is success!");
    }

/*    @Transactional
    public UpdateProductResponse updateProduct(Product product, Long id) {

        Product productFromDb = jpaProductRepository.findById(id).get();
        ProductList productList = jpaProductListRepository.findById(productFromDb.getProductList().getId()).get();
        User user = jpaUserRepository.findById(productList.getUser().getId()).get();

        product.setId(id);
        productList.setUser(user);
        product.setProductList(productList);
        jpaProductRepository.save(product);
        jpaProductListRepository.save(productList);
        jpaUserRepository.save(user);

        return new UpdateProductResponse(true, "Update is success!");
    }*/
}