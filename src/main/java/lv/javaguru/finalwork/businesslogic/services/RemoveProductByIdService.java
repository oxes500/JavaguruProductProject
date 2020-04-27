package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RemoveProductByIdService {

    private JPAProductRepository database;

    @Autowired
    public RemoveProductByIdService(JPAProductRepository database) {
        this.database = database;
    }

    public boolean removeProductById(Long idNumber) {
            database.deleteById(idNumber);
            return true;
        }
    }
