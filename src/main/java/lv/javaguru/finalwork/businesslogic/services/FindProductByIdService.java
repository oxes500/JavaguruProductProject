package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.ProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindProductByIdService {

    private ProductRepository database;

    @Autowired
    public FindProductByIdService(ProductRepository database) {
        this.database = database;
    }

    public Product findProductById(Long idNumber) {
        if (database.findById(idNumber).isPresent()) {
            return database.findById(idNumber).get();
        } else {
            return null;
        }
    }
}
