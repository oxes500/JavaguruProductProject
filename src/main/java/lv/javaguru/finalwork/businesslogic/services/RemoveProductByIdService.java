package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JDBCProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveProductByIdService {

    private JDBCProductRepository database;

    @Autowired
    public RemoveProductByIdService(JDBCProductRepository database) {
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