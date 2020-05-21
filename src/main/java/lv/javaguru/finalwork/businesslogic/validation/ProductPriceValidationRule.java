package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public boolean isValid(Product product) {
        return product.getPrice() != null
                && product.getPrice().compareTo(new BigDecimal("0.00")) > 0;
    }

    @Override
    public String errorMessage() {
        return "Product price shouldn't be empty and should be greater than 0";
    }
}
