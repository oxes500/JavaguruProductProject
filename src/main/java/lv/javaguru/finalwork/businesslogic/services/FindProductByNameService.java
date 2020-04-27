package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindProductByNameService {

    private JPAProductRepository database;

    @Autowired
    public FindProductByNameService(JPAProductRepository database) {
        this.database = database;
    }

    public Product findProductByName(String name) {
        if (database.findByName(name).isPresent()) {
            return database.findByName(name).get();
        } else {
            return null;
        }
    }
}