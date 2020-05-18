/*
package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.FindProductByNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductUiFindProductByName {

    @Autowired private FindProductByNameService findProductByNameService;

    public void findProductByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter Name of product to find it:");
        String productName = sc.nextLine();
        if (findProductByNameService.findProductByName(productName) != null) {
            System.out.println("Found product is: " + findProductByNameService.findProductByName(productName));
        } else {
            System.out.println("Product with name " + productName + " not found!");
        }
    }

}
*/
