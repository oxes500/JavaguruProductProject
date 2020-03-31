package FinalWork.businesslogic.validation;

import FinalWork.domain.Product;

public interface ProductValidationRule {

    boolean isValid(Product product);

    String errorMessage();

}
