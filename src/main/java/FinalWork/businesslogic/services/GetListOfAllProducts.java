package FinalWork.businesslogic.services;

import FinalWork.businesslogic.validation.DbIsNotEmpty;
import FinalWork.database.ProductDatabase;
import FinalWork.domain.Product;

import java.util.List;

public class GetListOfAllProducts {

    private DbIsNotEmpty dbIsNotEmpty;
    private ProductDatabase productDatabase;

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