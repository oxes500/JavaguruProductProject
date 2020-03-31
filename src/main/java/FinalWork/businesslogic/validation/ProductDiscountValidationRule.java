package FinalWork.businesslogic.validation;

import FinalWork.domain.Product;

import java.math.BigDecimal;

public class ProductDiscountValidationRule implements ProductValidationRule{

    @Override
    public boolean isValid(Product product) {
        BigDecimal emptyBD = new BigDecimal("");
        BigDecimal zeroBD = new BigDecimal("0.00");
        BigDecimal maxBD = new BigDecimal("1.00");
        return product.getDiscount() != null && !product.getDiscount().equals(emptyBD) && product.getDiscount().compareTo(zeroBD) > 0 && product.getDiscount().compareTo(maxBD) < 0;
    }

    @Override
    public String errorMessage() {
        return "Product discount should be between 1 and 100% (0.01 till 1.00)";
    }
}