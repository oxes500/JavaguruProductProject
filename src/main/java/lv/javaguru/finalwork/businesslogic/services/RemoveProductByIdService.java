package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.IdValidatorInDb;
import lv.javaguru.finalwork.database.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveProductByIdService {

    private IdValidatorInDb idValidatorInDb;
    private ProductDatabase database;

    @Autowired
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