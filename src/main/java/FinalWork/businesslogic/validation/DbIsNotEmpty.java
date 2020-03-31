package FinalWork.businesslogic.validation;

import FinalWork.database.ProductDatabase;

public class DbIsNotEmpty {

    private ProductDatabase productDatabase;

    public DbIsNotEmpty(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public boolean dbIsNotEmpty(){
        return productDatabase.containsProducts();
    }
}