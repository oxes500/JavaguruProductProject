package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.responses.AddProductResponse;
import lv.javaguru.finalwork.businesslogic.validation.ProductValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.ProductValidator;
import lv.javaguru.finalwork.domain.Product;
import lv.javaguru.finalwork.database.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddProductService {

    private ProductValidator productValidator;
    private ProductDatabase database;

    @Autowired
    public AddProductService(ProductDatabase database, ProductValidator productValidator) {
        this.database = database;
        this.productValidator = productValidator;
    }

    public AddProductResponse addProduct(Product product) {
        ProductValidationResponse validationResponse = productValidator.validate(product);
        if (!validationResponse.isSuccess()) {
            return new AddProductResponse(false, validationResponse.getErrorMessages());
        }
        database.addProduct(product);
        return new AddProductResponse(true, null);
    }
}