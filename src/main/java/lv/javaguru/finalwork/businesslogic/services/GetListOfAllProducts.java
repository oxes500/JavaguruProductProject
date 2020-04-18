package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.ProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetListOfAllProducts {

    private ProductRepository database;

    @Autowired
    public GetListOfAllProducts(ProductRepository database) {
        this.database = database;
    }

    public List<Product> getListOfAllProducts() {
        if (true) {
            return database.getProducts();
        } else {
            return null;
        }
    }
}