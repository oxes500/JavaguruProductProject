package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveProductByIdService {

    private ProductRepository database;

    @Autowired
    public RemoveProductByIdService(ProductRepository database) {
        this.database = database;
    }

    public boolean removeProductById(int idNumber) {
        if (true) {
            database.deleteById(idNumber);
            return true;
        } else {
            return false;
        }
    }
}