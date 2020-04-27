package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.RemoveProductByIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductUiRemoveProduct {

    private RemoveProductByIdService removeProductByIdService;

    @Autowired
    public ProductUiRemoveProduct(RemoveProductByIdService removeProductByIdService) {
        this.removeProductByIdService = removeProductByIdService;
    }

    public void removeProduct() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter ID of product to remove:");
            Long idOfProduct = Long.parseLong(sc.nextLine());
            if (removeProductByIdService.removeProductById(idOfProduct)) {
                System.out.println("Product with ID successfully deleted");
            } else {
                System.out.println("Number of ID is not correct!");
            }
        } catch (NumberFormatException e) {
            System.out.println("Please enter valid data type(number)!");
        }
    }

}
