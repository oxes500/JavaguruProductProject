package FinalWork.ui;

import FinalWork.businesslogic.validation.responses.AddProductResponse;
import FinalWork.businesslogic.services.*;
import FinalWork.businesslogic.validation.DbIsNotEmpty;
import FinalWork.businesslogic.validation.IdValidatorInDb;
import FinalWork.businesslogic.validation.ProductValidator;
import FinalWork.businesslogic.validation.responses.UpdateProductResponse;
import FinalWork.database.ProductDatabase;
import FinalWork.domain.Category;
import FinalWork.domain.Product;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductUI {

    public static void main(String[] args) {
        ProductDatabase database = new ProductDatabase();
        ProductValidator productValidator = new ProductValidator();
        AddProductService productService = new AddProductService(database, productValidator);
        IdValidatorInDb idValidatorInDb = new IdValidatorInDb(database);
        DbIsNotEmpty dbIsNotEmpty = new DbIsNotEmpty(database);
        FindProductByIdService findProductByIdService = new FindProductByIdService(idValidatorInDb, database);
        UpdateProductService updateProductService = new UpdateProductService(idValidatorInDb, database);
        RemoveProductByIdService removeProductByIdService = new RemoveProductByIdService(idValidatorInDb, database);
        GetListOfAllProducts getListOfAllProducts = new GetListOfAllProducts(dbIsNotEmpty, database);

        while (true) {
            System.out.println("Program menu:");
            System.out.println("1. Add new product");
            System.out.println("2. Find product by ID");
            System.out.println("3. Update product information by ID");
            System.out.println("4. Remove product by ID");
            System.out.println("5. View list of products");
            System.out.println("6. Exit");

            Scanner sc = new Scanner(System.in);
            System.out.println("Select option: ");
            int userChoice = Integer.parseInt(sc.nextLine());

            if (userChoice == 1) {
                System.out.println("Enter product name:");
                String productName = sc.nextLine();

                System.out.println("Enter product price:");
                BigDecimal productPrice = sc.nextBigDecimal();
                sc.nextLine();

                System.out.println("Please choose product category:");
                System.out.println("Enter 1 - vegetable, 2 - fruit, 3 - bread, 4 - drink");
                System.out.println("Enter 5 - milk, 6 - meat, 7 - fish");
                System.out.println("If there's no your category just press enter");

                int numberOfCategory = Integer.parseInt(sc.nextLine());
                ProductCategorySwitcherService categorySwitcher = new ProductCategorySwitcherService();
                Category category = categorySwitcher.getCategory(numberOfCategory);

                System.out.println("Enter product discount:");
                String productDiscount = sc.nextLine();

                System.out.println("Enter product description:");
                String productDescription = sc.nextLine();

                Product product = new Product(productName, new BigDecimal(String.valueOf(productPrice)), category, new BigDecimal(String.valueOf(productDiscount)), productDescription);

                AddProductResponse response = productService.addProduct(product);
                if (response.isSuccess()) {
                    System.out.println("Product successfully added in the list!");
                } else {
                    System.out.println("Operation failed!");
                    System.out.println("Error message: " + response.getErrorMessages());
                }
            }

            if (userChoice == 2) {
                System.out.println("Please enter ID of product to find it:");
                int idOfProduct = Integer.parseInt(sc.nextLine());
                if (findProductByIdService.findProductById(idOfProduct) != null) {
                    System.out.println("Found product is: " + findProductByIdService.findProductById(idOfProduct));
                } else {
                    System.out.println("Number of ID is not correct!");
                }
            }

            if (userChoice == 3) {
                System.out.println("Please enter ID of product to update it:");
                int idOfProduct = Integer.parseInt(sc.nextLine());

                System.out.println("Enter product name:");
                String productName = sc.nextLine();

                System.out.println("Enter product price:");
                BigDecimal productPrice = sc.nextBigDecimal();

                System.out.println("Please choose product category:");
                System.out.println("Enter 1 - vegetable, 2 - fruit, 3 - bread, 4 - drink");
                System.out.println("Enter 5 - milk, 6 - meat, 7 - fish");
                System.out.println("If there's no your category just press enter");

                int numberOfCategory = Integer.parseInt(sc.nextLine());
                ProductCategorySwitcherService categorySwitcher = new ProductCategorySwitcherService();
                Category category = categorySwitcher.getCategory(numberOfCategory);

                System.out.println("Enter product discount:");
                BigDecimal productDiscount = sc.nextBigDecimal();

                System.out.println("Enter product description:");
                String productDescription = sc.nextLine();

                Product product = new Product(productName, new BigDecimal(String.valueOf(productPrice)), category, new BigDecimal(String.valueOf(productDiscount)), productDescription);

                UpdateProductResponse response = updateProductService.updateProduct(product, idOfProduct);
                if (response.isSuccess()) {
                    System.out.println("Product successfully updated!");
                } else {
                    System.out.println("Operation failed!");
                    System.out.println("Error message: " + response.getErrorMessage());
                }
            }

            if (userChoice == 4) {
                System.out.println("Please enter ID of product to remove:");
                Integer idOfProduct = Integer.parseInt(sc.nextLine());
                if (removeProductByIdService.removeProductById(idOfProduct)) {
                    System.out.println("Product with ID successfully deleted");
                } else {
                    System.out.println("Number of ID is not correct!");
                }
            }

            if (userChoice == 5) {
                System.out.println("There is list of products");
                if (getListOfAllProducts.getListOfAllProducts() != null) {
                    System.out.println(getListOfAllProducts.getListOfAllProducts());
                } else {
                    System.out.println("List is empty, please add an item: ");
                }
            }

            if (userChoice == 6) {
                System.out.println("Goodbye!");
                break;
            }

            if (userChoice <1 || userChoice >6) {
                System.out.println("Please enter valid menu number");
            }

            System.out.println();
        }
    }
}
