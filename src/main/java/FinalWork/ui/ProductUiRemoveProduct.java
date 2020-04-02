package FinalWork.ui;

import FinalWork.businesslogic.services.RemoveProductByIdService;
import FinalWork.businesslogic.validation.IdValidatorInDb;
import FinalWork.database.ProductDatabase;

import java.util.Scanner;

public class ProductUiRemoveProduct {

    Scanner sc = new Scanner(System.in);
    ProductDatabase database = new ProductDatabase();
    IdValidatorInDb idValidatorInDb = new IdValidatorInDb(database);
    RemoveProductByIdService removeProductByIdService = new RemoveProductByIdService(idValidatorInDb, database);

    public void removeProduct() {
        System.out.println("Please enter ID of product to remove:");
        Integer idOfProduct = Integer.parseInt(sc.nextLine());
        if (removeProductByIdService.removeProductById(idOfProduct)) {
            System.out.println("Product with ID successfully deleted");
        } else {
            System.out.println("Number of ID is not correct!");
        }
    }

}
