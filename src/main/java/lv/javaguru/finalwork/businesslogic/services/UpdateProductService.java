package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.responses.UpdateProductResponse;
import lv.javaguru.finalwork.database.ProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductService {

    private ProductRepository database;

    @Autowired
    public UpdateProductService(ProductRepository database) {
        this.database = database;
    }

    public UpdateProductResponse updateProduct(Product product, Long id) {
        if (true) {
            product.setId(id);
            database.updateProduct(product);
            return new UpdateProductResponse(true, "Update is success!");
        } else {
            return new UpdateProductResponse(false, "Id is not found!");
        }
    }
}