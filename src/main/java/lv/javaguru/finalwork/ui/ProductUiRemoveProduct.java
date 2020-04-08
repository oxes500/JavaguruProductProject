package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.RemoveProductByIdService;
import lv.javaguru.finalwork.businesslogic.validation.IdValidatorInDb;
import lv.javaguru.finalwork.database.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductUiRemoveProduct {

    @Autowired private ProductDatabase database;
    @Autowired private IdValidatorInDb idValidatorInDb;
    @Autowired private RemoveProductByIdService removeProductByIdService;

    public void removeProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter ID of product to remove:");
        Integer idOfProduct = Integer.parseInt(sc.nextLine());
        if (removeProductByIdService.removeProductById(idOfProduct)) {
            System.out.println("Product with ID successfully deleted");
        } else {
            System.out.println("Number of ID is not correct!");
        }
    }

}
