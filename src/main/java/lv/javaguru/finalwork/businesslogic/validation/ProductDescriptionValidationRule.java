package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDescriptionValidationRule implements ProductValidationRule{

    @Override
    public boolean isValid(Product product) {
        return product.getDescription() != null && !product.getDescription().equals("") && product.getDescription().length() <= 100;
    }

    @Override
    public String errorMessage() {
        return "Product description length should be from 0 to 100 symbols";
    }
}
