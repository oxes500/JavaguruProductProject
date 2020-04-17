package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JDBCProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindProductByIdService {

    private JDBCProductRepository database;

    @Autowired
    public FindProductByIdService(JDBCProductRepository database) {
        this.database = database;
    }

    public Product findProductById(int idNumber) {
        if (database.findById(idNumber).isPresent()) {
            return database.findById(idNumber).get();
        } else {
            return null;
        }
    }
}
