package FinalWork.businesslogic.validation;

import FinalWork.database.ProductDatabase;

public class IdValidatorInDb {

    private ProductDatabase productDatabase;

    public IdValidatorInDb(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public boolean validateId(int idNumber) {
        return productDatabase.containsId(idNumber);
    }

}
