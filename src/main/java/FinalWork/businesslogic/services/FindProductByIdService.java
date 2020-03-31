package FinalWork.businesslogic.services;

import FinalWork.businesslogic.validation.IdValidatorInDb;
import FinalWork.database.ProductDatabase;
import FinalWork.domain.Product;

public class FindProductByIdService {

    private IdValidatorInDb idValidatorInDb;
    private ProductDatabase database;

    public FindProductByIdService(IdValidatorInDb idValidatorInDb, ProductDatabase database) {
        this.idValidatorInDb = idValidatorInDb;
        this.database = database;
    }

    public Product findProductById(int idNumber) {
        if (idValidatorInDb.validateId(idNumber)) {
            return database.getProductByID(idNumber);
        } else {
            return null;
        }
    }
}
