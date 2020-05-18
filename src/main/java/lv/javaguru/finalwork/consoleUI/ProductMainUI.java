/*
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
    @Autowired private ProductUiFindProductByName productUiFindProductByName;
    @Autowired private ProductUiGetByCategory productUiGetByCategory;

    public void executeMainUI() {

        while (true) {
            System.out.println("Program menu:");
            System.out.println("1. Add new product");
            System.out.println("2. Find product by ID");
            System.out.println("3. Find product by Name");
            System.out.println("4. Find products by Category");
            System.out.println("5. Update product information by ID");
            System.out.println("6. Remove product by ID");
            System.out.println("7. View list of products");
            System.out.println("8. Exit");

            Scanner sc = new Scanner(System.in);
            System.out.println("Select option: ");
            String userChoice = sc.nextLine();

            if (userChoice.equals("1")) {
                productUiAddProduct.addProduct();
            }
            if (userChoice.equals("2")) {
                productUiFindProductById.findProductById();
            }
            if (userChoice.equals("3")) {
                productUiFindProductByName.findProductByName();
            }
            if (userChoice.equals("4")) {
                productUiGetByCategory.getListByCategory();
            }
            if (userChoice.equals("5")) {
                productUiUpdateProduct.updateProduct();
            }
            if (userChoice.equals("6")) {
                productUiRemoveProduct.removeProduct();
            }
            if (userChoice.equals("7")) {
                productUiViewList.viewList();
            }
            if (userChoice.equals("8")) {
                System.out.println("Goodbye!");
                break;
            }
            if (userChoice.isEmpty()) {
                System.out.println("First type number, then press enter valid menu number");
            }
            System.out.println("");
        }
    }
}*/
