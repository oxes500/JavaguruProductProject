package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JPAProductRepository;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Component
public class GetProductsByCategoryService {

    @Autowired private JPAProductRepository database;

    @Transactional
    public List<Product> getListByCategory(Category category) {
        return StreamSupport
                .stream(database.findAll().spliterator(), false)
                .filter(product -> product.getCategory().equals(category))
                .collect(Collectors.toList());
        }
    }
