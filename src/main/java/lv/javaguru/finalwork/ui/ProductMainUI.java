package lv.javaguru.finalwork.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductMainUI {

    @Autowired private ProductUiAddProduct productUiAddProduct;
    @Autowired private ProductUiFindProductById productUiFindProductById;
    @Autowired private ProductUiRemoveProduct productUiRemoveProduct;
    @Autowired private ProductUiUpdateProduct productUiUpdateProduct;
    @Autowired private ProductUiViewList productUiViewList;

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
