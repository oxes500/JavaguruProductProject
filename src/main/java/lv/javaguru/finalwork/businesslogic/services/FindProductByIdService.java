package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FindProductByIdService {

    @Autowired private JPAProductRepository database;

    public FindProductByIdService(JPAProductRepository database) {
        this.database = database;
    }

    @Transactional
    public Product findProductById(Long idNumber) {
        if (database.findById(idNumber).isPresent()) {
            return database.findById(idNumber).get();
        } else {
            return null;
        }
    }
}
