package FinalWork.businesslogic.services;

import FinalWork.businesslogic.validation.responses.AddProductResponse;
import FinalWork.businesslogic.validation.ProductValidationResponse;
import FinalWork.businesslogic.validation.ProductValidator;
import FinalWork.domain.Product;
import FinalWork.database.ProductDatabase;

public class AddProductService {

    private ProductValidator productValidator;
    private ProductDatabase database;

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