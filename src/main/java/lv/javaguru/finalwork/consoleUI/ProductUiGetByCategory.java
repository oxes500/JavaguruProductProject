/*
package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.GetProductsByCategoryService;
import lv.javaguru.finalwork.businesslogic.services.ProductCategorySwitcherService;
import lv.javaguru.finalwork.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductUiGetByCategory {

    private GetProductsByCategoryService getProductsByCategoryService;

    @Autowired
    public ProductUiGetByCategory(GetProductsByCategoryService getProductsByCategoryService) {
        this.getProductsByCategoryService = getProductsByCategoryService;
    }

    public void getListByCategory() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choose product category:");
        System.out.println("Enter 1 - vegetable, 2 - fruit, 3 - bread, 4 - drink");
        System.out.println("Enter 5 - milk, 6 - meat, 7 - fish");

        String numberOfCategory = sc.nextLine();
        ProductCategorySwitcherService categorySwitcher = new ProductCategorySwitcherService();
        Category category = categorySwitcher.getCategory(numberOfCategory);

        if (getProductsByCategoryService.getListByCategory(category) != null) {
            System.out.println(getProductsByCategoryService.getListByCategory(category));
        } else {
            System.out.println("Category is empty, please add an item:");
        }
    }
}*/
