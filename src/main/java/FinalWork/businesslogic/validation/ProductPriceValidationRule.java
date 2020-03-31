package FinalWork.businesslogic.validation;

import FinalWork.domain.Product;

import java.math.BigDecimal;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public boolean isValid(Product product) {
        BigDecimal emptyBD = new BigDecimal("");
        BigDecimal zeroBD = new BigDecimal("0.00");
        return product.getPrice() != null && !product.getPrice().equals(emptyBD) && product.getPrice().compareTo(zeroBD) > 0;
    }

    @Override
    public String errorMessage() {
        return "Product price shouldn't be empty and should be greater than 0";
    }
}
