package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.ProductCategorySwitcherService;
import lv.javaguru.finalwork.businesslogic.services.UpdateProductService;
import lv.javaguru.finalwork.businesslogic.validation.responses.UpdateProductResponse;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Scanner;

@Component
public class ProductUiUpdateProduct {

    private UpdateProductService updateProductService;

    @Autowired
    public ProductUiUpdateProduct(UpdateProductService updateProductService) {
        this.updateProductService = updateProductService;
    }

    public void updateProduct() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter ID of product to update it:");
            Long idOfProduct = Long.parseLong(sc.nextLine());

            System.out.println("Enter product name:");
            String productName = sc.nextLine();

            System.out.println("Enter product price:");
            String productRawPrice = sc.nextLine();
            BigDecimal productPrice = new BigDecimal(productRawPrice);

            System.out.println("Please choose product category:");
            System.out.println("Enter 1 - vegetable, 2 - fruit, 3 - bread, 4 - drink");
            System.out.println("Enter 5 - milk, 6 - meat, 7 - fish");
            System.out.println("If there's no your category just press enter");

            String numberOfCategory = sc.nextLine();
            ProductCategorySwitcherService categorySwitcher = new ProductCategorySwitcherService();
            Category category = categorySwitcher.getCategory(numberOfCategory);

            System.out.println("Enter product discount:");
            String productRawDiscount = sc.nextLine();
            BigDecimal productDiscount = new BigDecimal(productRawDiscount);

            System.out.println("Enter product description:");
            String productDescription = sc.nextLine();

            Product product = new Product(productName, productPrice, category, productDiscount, productDescription);

            UpdateProductResponse response = updateProductService.updateProduct(product, idOfProduct);
            if (response.isSuccess()) {
                System.out.println("Product successfully updated!");
            } else {
                System.out.println("Operation failed!");
                System.out.println("Error message: " + response.getErrorMessage());
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid data type!");
        }

    }

}
