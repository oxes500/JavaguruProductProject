package FinalWork.ui;

import FinalWork.businesslogic.services.FindProductByIdService;
import FinalWork.businesslogic.validation.IdValidatorInDb;
import FinalWork.database.ProductDatabase;

import java.util.Scanner;

public class ProductUiFindProductById {

    Scanner sc = new Scanner(System.in);
    ProductDatabase database = new ProductDatabase();
    IdValidatorInDb idValidatorInDb = new IdValidatorInDb(database);
    FindProductByIdService findProductByIdService = new FindProductByIdService(idValidatorInDb, database);

    public void findProductById() {
        System.out.println("Please enter ID of product to find it:");
        int idOfProduct = Integer.parseInt(sc.nextLine());
        if (findProductByIdService.findProductById(idOfProduct) != null) {
            System.out.println("Found product is: " + findProductByIdService.findProductById(idOfProduct));
        } else {
            System.out.println("Number of ID is not correct!");
        }
    }

}