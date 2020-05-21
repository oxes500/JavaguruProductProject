package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule{

    @Override
    public boolean isValid(Product product) {
        return product.getDiscount() != null
                && product.getDiscount().compareTo(new BigDecimal("0.00")) > 0
                && product.getDiscount().compareTo(new BigDecimal("1.00")) < 0;
    }

    @Override
    public String errorMessage() {
        return "Product discount should be between 1 and 100% (0.01 till 1.00)";
    }
}