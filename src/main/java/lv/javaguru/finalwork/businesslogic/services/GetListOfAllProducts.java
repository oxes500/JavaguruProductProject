package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.database.JDBCProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetListOfAllProducts {

    private JDBCProductRepository database;

    @Autowired
    public GetListOfAllProducts(JDBCProductRepository database) {
        this.database = database;
    }

    public List<Product> getListOfAllProducts() {
        if (true) {
            return database.getProducts();
        } else {
            return null;
        }
    }
}