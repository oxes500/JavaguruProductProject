package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.IdValidatorInDb;
import lv.javaguru.finalwork.businesslogic.validation.responses.UpdateProductResponse;
import lv.javaguru.finalwork.database.ProductDatabase;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductService {

    private IdValidatorInDb idValidatorInDb;
    private ProductDatabase productDatabase;

    @Autowired
    public UpdateProductService(IdValidatorInDb idValidatorInDb, ProductDatabase productDatabase) {
        this.idValidatorInDb = idValidatorInDb;
        this.productDatabase = productDatabase;
    }

    public UpdateProductResponse updateProduct(Product product, int id) {
        if (idValidatorInDb.validateId(id)) {
            productDatabase.updateProduct(product);
            return new UpdateProductResponse(true, "Update is success!");
        } else {
            return new UpdateProductResponse(false, "Id is not found!");
        }
    }
}