package FinalWork.businesslogic.services;

import FinalWork.businesslogic.validation.IdValidatorInDb;
import FinalWork.businesslogic.validation.responses.UpdateProductResponse;
import FinalWork.database.ProductDatabase;
import FinalWork.domain.Product;

public class UpdateProductService {

    private IdValidatorInDb idValidatorInDb;
    private ProductDatabase productDatabase;

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