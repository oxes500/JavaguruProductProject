package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.responses.UpdateProductResponse;
import lv.javaguru.finalwork.database.JDBCProductRepository;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateProductService {

    private JDBCProductRepository database;

    @Autowired
    public UpdateProductService(JDBCProductRepository database) {
        this.database = database;
    }

    public UpdateProductResponse updateProduct(Product product, int id) {
        if (true) {
            database.updateProduct(product);
            return new UpdateProductResponse(true, "Update is success!");
        } else {
            return new UpdateProductResponse(false, "Id is not found!");
        }
    }
}