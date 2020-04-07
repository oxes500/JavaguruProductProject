package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.database.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class IdValidatorInDb {

    private ProductDatabase productDatabase;

    @Autowired
    public IdValidatorInDb(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public boolean validateId(int idNumber) {
        return productDatabase.containsId(idNumber);
    }

}
