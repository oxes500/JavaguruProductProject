package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.responses.UpdateProductResponse;
import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductService {

    private JPAProductRepository database;

    @Autowired
    public UpdateProductService(JPAProductRepository database) {
        this.database = database;
    }

    public UpdateProductResponse updateProduct(Product product, Long id) {
        product.setId(id);
        Product productFromDb = database.findById(id).get();
        database.save(productFromDb);
        return new UpdateProductResponse(true, "Update is success!");
    }
}