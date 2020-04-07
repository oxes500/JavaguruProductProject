package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.IdValidatorInDb;
import lv.javaguru.finalwork.database.ProductDatabase;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindProductByIdService {

    private IdValidatorInDb idValidatorInDb;
    private ProductDatabase database;

    @Autowired
    public FindProductByIdService(IdValidatorInDb idValidatorInDb, ProductDatabase database) {
        this.idValidatorInDb = idValidatorInDb;
        this.database = database;
    }

    public Product findProductById(int idNumber) {
        if (idValidatorInDb.validateId(idNumber)) {
            return database.getProductByID(idNumber - 1);
        } else {
            return null;
        }
    }
}
