/*
package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.AddProductToPreviousListService;
import lv.javaguru.finalwork.businesslogic.services.AddProductService;
import lv.javaguru.finalwork.businesslogic.services.ProductCategorySwitcherService;
import lv.javaguru.finalwork.businesslogic.validation.responses.AddProductResponse;
import lv.javaguru.finalwork.domain.Category;
import lv.javaguru.finalwork.domain.Product;
import lv.javaguru.finalwork.domain.ProductList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Scanner;

import static lv.javaguru.finalwork.ui.ProductLoginUI.logedInUser;

@Component
public class ProductUiAddProduct {

    private AddProductService productService;
    private AddProductToPreviousListService prodcutServiceToCreatedListService;

    @Autowired
    public ProductUiAddProduct(AddProductService productService, AddProductToPreviousListService prodcutServiceToCreatedListService) {
        this.productService = productService;
        this.prodcutServiceToCreatedListService = prodcutServiceToCreatedListService;
    }

    private ProductList productList = new ProductList();

    @Transactional
    public void addProduct() {
        try {
            System.out.println("1. Add product in new list");
            System.out.println("2. Add product in previous list");
            System.out.println("3. Add product in existing list");
            System.out.println("4. Exit to main menu");
            Scanner sc = new Scanner(System.in);
            String userChoice = sc.nextLine();

            while (true) {
                if (userChoice.equals("1")) {

                    System.out.println("It's time to create product list:");
                    System.out.println("Enter list title:");
                    String productListTitle = sc.nextLine();

                    System.out.println("Enter product list description:");
                    String productListTitleDescription = sc.nextLine();

                    productList.setTitle(productListTitle);
                    productList.setDescription(productListTitleDescription);

                    System.out.println("Product list has been created");
                    System.out.println("");

                    System.out.println("Enter product name:");
                    String productName = sc.nextLine();

                    System.out.println("Enter product price:");
                    String productRawPrice = sc.nextLine();
                    BigDecimal productPrice = new BigDecimal(productRawPrice);

                    System.out.println("Please choose product category:");
                    System.out.println("Enter 1 - vegetable, 2 - fruit, 3 - bread, 4 - drink");
                    System.out.println("Enter 5 - milk, 6 - meat, 7 - fish");

                    String numberOfCategory = sc.nextLine();
                    ProductCategorySwitcherService categorySwitcher = new ProductCategorySwitcherService();
                    Category category = categorySwitcher.getCategory(numberOfCategory);

                    System.out.println("Enter product discount:");
                    String productRawDiscount = sc.nextLine();
                    BigDecimal productDiscount = new BigDecimal(productRawDiscount);

                    System.out.println("Enter product description:");
                    String productDescription = sc.nextLine();

                    Product product = new Product(productName, productPrice, category, productDiscount, productDescription);

                    AddProductResponse response = productService.addProduct(product, productList, logedInUser);
                    if (response.isSuccess()) {
                        System.out.println("Product successfully added in the list!");
                    } else {
                        System.out.println("Operation failed!");
                        System.out.println("Error message: " + response.getErrorMessages());
                    }
                    System.out.println("");
                    System.out.println("1. Add an item");
                    System.out.println("2. Exit to main menu");
                    String choice = sc.nextLine();
                    if (choice.equals("1")) {
                        userChoice = "2";
                    } else {
                        break;
                    }
                }
                if (userChoice.equals("2")) {

                    if (productList.getTitle() == null) {
                        System.out.println("Enter list title:");
                        String productListTitle = sc.nextLine();

                        System.out.println("Enter product list description:");
                        String productListTitleDescription = sc.nextLine();

                        productList.setTitle(productListTitle);
                        productList.setDescription(productListTitleDescription);
                    } else {
                        System.out.println("Enter product name:");
                        String productName = sc.nextLine();

                        System.out.println("Enter product price:");
                        String productRawPrice = sc.nextLine();
                        BigDecimal productPrice = new BigDecimal(productRawPrice);

                        System.out.println("Please choose product category:");
                        System.out.println("Enter 1 - vegetable, 2 - fruit, 3 - bread, 4 - drink");
                        System.out.println("Enter 5 - milk, 6 - meat, 7 - fish");

                        String numberOfCategory = sc.nextLine();
                        ProductCategorySwitcherService categorySwitcher = new ProductCategorySwitcherService();
                        Category category = categorySwitcher.getCategory(numberOfCategory);

                        System.out.println("Enter product discount:");
                        String productRawDiscount = sc.nextLine();
                        BigDecimal productDiscount = new BigDecimal(productRawDiscount);

                        System.out.println("Enter product description:");
                        String productDescription = sc.nextLine();

                        Product product = new Product(productName, productPrice, category, productDiscount, productDescription);

                        AddProductResponse response = prodcutServiceToCreatedListService.addProduct(product, productList, logedInUser);
                        if (response.isSuccess()) {
                            System.out.println("Product successfully added in the list!");
                        } else {
                            System.out.println("Operation failed!");
                            System.out.println("Error message: " + response.getErrorMessages());
                        }
                        System.out.println("");
                        System.out.println("1. Add an item");
                        System.out.println("2. Exit to main menu");
                        String choice = sc.nextLine();
                        if (choice.equals("1")) {
                            userChoice = "2";
                        } else {
                            break;
                        }
                    }
                }
                if (userChoice.equals("3")) {

                        System.out.println("Enter list title:");
                        String productListTitle = sc.nextLine();

                        productList.setTitle(productListTitle);

                        System.out.println("Enter product name:");
                        String productName = sc.nextLine();

                        System.out.println("Enter product price:");
                        String productRawPrice = sc.nextLine();
                        BigDecimal productPrice = new BigDecimal(productRawPrice);

                        System.out.println("Please choose product category:");
                        System.out.println("Enter 1 - vegetable, 2 - fruit, 3 - bread, 4 - drink");
                        System.out.println("Enter 5 - milk, 6 - meat, 7 - fish");

                        String numberOfCategory = sc.nextLine();
                        ProductCategorySwitcherService categorySwitcher = new ProductCategorySwitcherService();
                        Category category = categorySwitcher.getCategory(numberOfCategory);

                        System.out.println("Enter product discount:");
                        String productRawDiscount = sc.nextLine();
                        BigDecimal productDiscount = new BigDecimal(productRawDiscount);

                        System.out.println("Enter product description:");
                        String productDescription = sc.nextLine();

                        Product product = new Product(productName, productPrice, category, productDiscount, productDescription);

                        AddProductResponse response = prodcutServiceToCreatedListService.addProduct(product, productList, logedInUser);
                        if (response.isSuccess()) {
                            System.out.println("Product successfully added in the list!");
                        } else {
                            System.out.println("Operation failed!");
                            System.out.println("Error message: " + response.getErrorMessages());
                        }
                        System.out.println("");
                        System.out.println("1. Add an item");
                        System.out.println("2. Exit to main menu");
                        String choice = sc.nextLine();
                        if (choice.equals("1")) {
                            userChoice = "2";
                        } else {
                            break;
                        }
                    }
                if (userChoice.equals("4")) {
                    System.out.println("Going to main menu");
                    break;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid data type");
        }
    }
}*/
