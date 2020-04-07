package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Product;

public interface ProductValidationRule {

    boolean isValid(Product product);

    String errorMessage();

}
