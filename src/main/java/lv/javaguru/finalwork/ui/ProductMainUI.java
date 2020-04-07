package lv.javaguru.finalwork.ui;

import java.util.Scanner;

public class ProductMainUI {

    ProductUiAddProduct productUiAddProduct = new ProductUiAddProduct();
    ProductUiFindProductById productUiFindProductById = new ProductUiFindProductById();
    ProductUiRemoveProduct productUiRemoveProduct = new ProductUiRemoveProduct();
    ProductUiUpdateProduct productUiUpdateProduct = new ProductUiUpdateProduct();
    ProductUiViewList productUiViewList = new ProductUiViewList();

    public void execute() {
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
                productUiAddProduct.addProduct();
            }
            if (userChoice == 2) {
                productUiFindProductById.findProductById();
            }
            if (userChoice == 3) {
                productUiUpdateProduct.updateProduct();
            }
            if (userChoice == 4) {
                productUiRemoveProduct.removeProduct();
            }
            if (userChoice == 5) {
                productUiViewList.viewList();
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
