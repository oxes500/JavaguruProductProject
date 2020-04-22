package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.FindProductByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductUiFindProductById {

    @Autowired private FindProductByIdService findProductByIdService;

    public void findProductById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ID of product to find it:");
        Long idOfProduct = Long.parseLong(sc.nextLine());
        if (findProductByIdService.findProductById(idOfProduct) != null) {
            System.out.println("Found product is: " + findProductByIdService.findProductById(idOfProduct));
        } else {
            System.out.println("Product with ID " + idOfProduct + " not found!");
        }
    }
}