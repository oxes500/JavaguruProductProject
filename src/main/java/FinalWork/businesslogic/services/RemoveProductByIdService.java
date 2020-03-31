package FinalWork.businesslogic.services;

import FinalWork.businesslogic.validation.IdValidatorInDb;
import FinalWork.database.ProductDatabase;

public class RemoveProductByIdService {

    private IdValidatorInDb idValidatorInDb;
    private ProductDatabase database;

    public RemoveProductByIdService(IdValidatorInDb idValidatorInDb, ProductDatabase database) {
        this.idValidatorInDb = idValidatorInDb;
        this.database = database;
    }

    public boolean removeProductById(int idNumber) {
        if (idValidatorInDb.validateId(idNumber)) {
            database.removeProductById(idNumber);
            return true;
        } else {
            return false;
        }
    }
}