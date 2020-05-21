package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductNameValidationRule implements ProductValidationRule{

    @Override
    public boolean isValid(Product product) {
        return product.getName() != null
                && !product.getName().equals("")
                && (product.getName().length() > 3
                && product.getName().length() <= 32);
    }

    @Override
    public String errorMessage() {
        return "Product name shouldn't be empty and this length should be from 3 to 32 symbols!";
    }
}
