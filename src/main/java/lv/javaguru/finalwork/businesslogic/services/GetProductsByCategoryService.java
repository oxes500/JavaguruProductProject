package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.ProductRepository;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetProductsByCategoryService {

    private ProductRepository database;

    @Autowired
    public GetProductsByCategoryService(ProductRepository database) {
        this.database = database;
    }

    public List<Product> getListByCategory(Category category) {
        if (true) {
            return database.getProductByCategory(category);
        } else {
            return null;
        }
    }
}