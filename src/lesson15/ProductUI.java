package lesson15;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductUI {

    public static void main(String[] args) {
        ProductDatabase database = new ProductDatabase();
        ProductService productService = new ProductService(database);

        while (true) {
            // print menu
            System.out.println("Program menu:");
            System.out.println("1. Add new product");
            System.out.println("2. Get product by ID");
            System.out.println("3. View list of products");
            System.out.println("4. Delete product by ID");
            System.out.println("5. Exit");

            // get user choice
            Scanner sc = new Scanner(System.in);
            System.out.println("Select option: ");
            int userChoice = Integer.parseInt(sc.nextLine());

            // execute user choice
            if (userChoice == 1) {
                // add new product
                System.out.println("Enter product name:");
                String productName = sc.nextLine();
                System.out.println("Enter product price:");
                String productPrice = sc.nextLine();
                Product product = new Product(productName, new BigDecimal(productPrice));
                // invoke BL
                ProductResponse response = productService.addProduct(product);
                if (response.isSuccess()) {
                    System.out.println("Product successfully added in the list!");
                } else {
                    System.out.println("Operation failed!");
                    System.out.println("Error message: " + response.getErrorMessage());
                }
            }

            if (userChoice == 2) {
                //Validate ID, if id isn't exist return id isn't correct or product isn't exist
                // Get product by ID
                System.out.println("Please enter ID of product to find it:");
                int idOfProduct = Integer.parseInt(sc.nextLine());
                if (productService.dbContainsId(idOfProduct)) {
                    Product foundProduct = productService.getProductById(idOfProduct);
                    System.out.println("Found product is:");
                    System.out.println(foundProduct);
                } else {
                    System.out.println("Sorry ID not found");
                }
            }

            if (userChoice == 3) {
                //If empty list, say list is empty
                if (productService.dbIsNotEmpty()) {
                    System.out.println("There are all products in the list");
                    System.out.println(productService.getProductList());
                } else {
                    System.out.println("List is empty, please add a product");
                }
            }

            if (userChoice == 4) {
                // Delete product by ID
                System.out.println("Please enter ID of product to delete:");
                Integer idOfProduct = Integer.parseInt(sc.nextLine());
                ProductResponse response = productService.removeProductByID(idOfProduct);
                if (response.isSuccess()) {
                    System.out.println("Product successfully deleted from the list!");
                } else {
                    System.out.println("Operation failed!");
                    System.out.println("Error message: " + response.getErrorMessage());
                }
            }

            if (userChoice == 5) {
                // Exit
                System.out.println("Goodbye!");
                break;
            }

            if (userChoice <1 || userChoice >5) {
                System.out.println("Please enter valid menu number");
            }

            System.out.println();

            // exit condition
        }

    }

}
