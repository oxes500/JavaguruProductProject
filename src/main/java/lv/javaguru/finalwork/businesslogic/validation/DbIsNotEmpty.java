package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.database.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DbIsNotEmpty {

    private ProductDatabase productDatabase;

    @Autowired
    public DbIsNotEmpty(ProductDatabase productDatabase) {
        this.productDatabase = productDatabase;
    }

    public boolean dbIsNotEmpty(){
        return productDatabase.containsProducts();
    }
}