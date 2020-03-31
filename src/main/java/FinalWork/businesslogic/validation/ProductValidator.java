package FinalWork.businesslogic.validation;

import FinalWork.domain.Product;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class ProductValidator {

    private List<ProductValidationRule> validationRules;

    public ProductValidator() {
        validationRules = new ArrayList<>();
        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductDescriptionValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductPriceValidationRule());
    }

    public ProductValidationResponse validate(Product product) {
        List<String> errorMessages =
                validationRules.stream()
                        .filter(rule -> !rule.isValid(product))
                        .map(ProductValidationRule::errorMessage)
                        .collect(toList());
        if (errorMessages.isEmpty()) {
            return new ProductValidationResponse(true, null);
        } else {
            return new ProductValidationResponse(false, errorMessages);
        }
    }
}