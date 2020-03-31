package FinalWork.businesslogic.validation;

import FinalWork.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule{

    @Override
    public boolean isValid(Product product) {
        return product.getDiscount() != null && product.getDiscount().compareTo(new BigDecimal("0.00")) > 0 && product.getDiscount().compareTo(new BigDecimal("1.00")) < 0;
    }

    @Override
    public String errorMessage() {
        return "Product discount should be between 1 and 100% (0.01 till 1.00)";
    }
}