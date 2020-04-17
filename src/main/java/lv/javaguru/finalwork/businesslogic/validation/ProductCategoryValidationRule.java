package lv.javaguru.finalwork.businesslogic.validation;

import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryValidationRule implements ProductValidationRule{

    @Override
    public boolean isValid(Product product) {
        return product.getCategory() != null && !product.getCategory().equals("") && ((product.getCategory().equals(Category.VEGETABLE))
                || (product.getCategory().equals(Category.BREAD))
                || (product.getCategory().equals(Category.FRUIT))
                || (product.getCategory().equals(Category.DRINK))
                || (product.getCategory().equals(Category.MILK))
                || (product.getCategory().equals(Category.MEAT))
                || (product.getCategory().equals(Category.FISH))
                || (product.getCategory().equals(Category.NOT_APPLICABLE))
        );
    }

    @Override
    public String errorMessage() {
        return "Please enter valid number of Category";
    }
}