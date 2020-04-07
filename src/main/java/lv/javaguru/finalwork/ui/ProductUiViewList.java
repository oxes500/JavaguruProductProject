package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.GetListOfAllProducts;
import lv.javaguru.finalwork.businesslogic.validation.DbIsNotEmpty;
import lv.javaguru.finalwork.database.ProductDatabase;

public class ProductUiViewList {

    ProductDatabase database = new ProductDatabase();
    DbIsNotEmpty dbIsNotEmpty = new DbIsNotEmpty(database);
    GetListOfAllProducts getListOfAllProducts = new GetListOfAllProducts(dbIsNotEmpty, database);

    public void viewList() {
        System.out.println("There is list of products");
        if (getListOfAllProducts.getListOfAllProducts() != null) {
            System.out.println(getListOfAllProducts.getListOfAllProducts());
        } else {
            System.out.println("List is empty, please add an item: ");
        }
    }
}