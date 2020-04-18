package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.ProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindProductByNameService {

    private ProductRepository database;

    @Autowired
    public FindProductByNameService(ProductRepository database) {
        this.database = database;
    }

    public Product findProductByName(String name) {
        if (database.findProductByName(name).isPresent()) {
            return database.findProductByName(name).get();
        } else {
            return null;
        }
    }
}
