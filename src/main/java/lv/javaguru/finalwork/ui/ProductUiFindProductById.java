package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.FindProductByIdService;
import lv.javaguru.finalwork.businesslogic.validation.IdValidatorInDb;
import lv.javaguru.finalwork.database.ProductDatabase;

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