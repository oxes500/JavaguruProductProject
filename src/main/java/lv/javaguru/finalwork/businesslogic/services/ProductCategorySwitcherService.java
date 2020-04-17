package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.domain.Category;
import org.springframework.stereotype.Component;

@Component
public class ProductCategorySwitcherService {

    public Category getCategory(String numberOfCategory) {
        Category foundCategory = Category.NOT_APPLICABLE;
        switch (numberOfCategory) {
            case "1":
                foundCategory = Category.VEGETABLE;
                break;
            case "2":
                foundCategory = Category.FRUIT;
                break;
            case "3":
                foundCategory = Category.BREAD;
                break;
            case "4":
                foundCategory = Category.DRINK;
                break;
            case "5":
                foundCategory = Category.MILK;
                break;
            case "6":
                foundCategory = Category.MEAT;
                break;
            case "7":
                foundCategory = Category.FISH;
                break;
        }
        return foundCategory;
    }
}
