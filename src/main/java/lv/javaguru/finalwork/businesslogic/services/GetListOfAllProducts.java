package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.DbIsNotEmpty;
import lv.javaguru.finalwork.database.ProductDatabase;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetListOfAllProducts {

    private DbIsNotEmpty dbIsNotEmpty;
    private ProductDatabase productDatabase;

    @Autowired
    public GetListOfAllProducts(DbIsNotEmpty dbIsNotEmpty, ProductDatabase productDatabase) {
        this.dbIsNotEmpty = dbIsNotEmpty;
        this.productDatabase = productDatabase;
    }

    public List<Product> getListOfAllProducts() {
        if (dbIsNotEmpty.dbIsNotEmpty()) {
            return productDatabase.getProducts();
        } else {
            return null;
        }
    }
}