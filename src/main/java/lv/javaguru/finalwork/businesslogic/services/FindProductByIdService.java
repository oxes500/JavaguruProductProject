package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindProductByIdService {

    private JPAProductRepository database;

    @Autowired
    public FindProductByIdService(JPAProductRepository database) {
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
