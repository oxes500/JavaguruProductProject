package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class GetListOfAllProducts {

    @Autowired private JPAProductRepository database;

    @Transactional
    public List<Product> getListOfAllProducts() {
        database.findAll();
        return StreamSupport
                .stream(database.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}