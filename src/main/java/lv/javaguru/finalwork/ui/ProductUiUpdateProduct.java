package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.ProductCategorySwitcherService;
import lv.javaguru.finalwork.businesslogic.services.UpdateProductService;
import lv.javaguru.finalwork.businesslogic.validation.IdValidatorInDb;
import lv.javaguru.finalwork.businesslogic.validation.responses.UpdateProductResponse;
import lv.javaguru.finalwork.database.ProductDatabase;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductUiUpdateProduct {

    Scanner sc = new Scanner(System.in);
    ProductDatabase database = new ProductDatabase();
    IdValidatorInDb idValidatorInDb = new IdValidatorInDb(database);
    UpdateProductService updateProductService = new UpdateProductService(idValidatorInDb, database);

    public void updateProduct() {
        System.out.println("Please enter ID of product to update it:");
        int idOfProduct = Integer.parseInt(sc.nextLine());

        System.out.println("Enter product name:");
        String productName = sc.nextLine();

        System.out.println("Enter product price:");
        Double productRawPrice = Double.parseDouble(sc.nextLine());
        BigDecimal productPrice = new BigDecimal(productRawPrice);

        System.out.println("Please choose product category:");
        System.out.println("Enter 1 - vegetable, 2 - fruit, 3 - bread, 4 - drink");
        System.out.println("Enter 5 - milk, 6 - meat, 7 - fish");
        System.out.println("If there's no your category just press enter");

        int numberOfCategory = Integer.parseInt(sc.nextLine());
        ProductCategorySwitcherService categorySwitcher = new ProductCategorySwitcherService();
        Category category = categorySwitcher.getCategory(numberOfCategory);

        System.out.println("Enter product discount:");
        Double productRawDiscount = Double.parseDouble(sc.nextLine());
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
    }

}
