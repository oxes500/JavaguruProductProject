package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RemoveProductByIdService {

    @Autowired private JPAProductRepository database;

    public RemoveProductByIdService(JPAProductRepository database) {
        this.database = database;
    }

    @Transactional
    public boolean removeProductById(Long idNumber) {
            database.deleteById(idNumber);
            return true;
        }
    }
