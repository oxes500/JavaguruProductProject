package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.GetListOfAllProducts;
import lv.javaguru.finalwork.businesslogic.validation.DbIsNotEmpty;
import lv.javaguru.finalwork.database.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUiViewList {

    @Autowired private ProductDatabase database;
    @Autowired private DbIsNotEmpty dbIsNotEmpty;
    @Autowired private GetListOfAllProducts getListOfAllProducts;

    public void viewList() {
        System.out.println("There is list of products");
        if (getListOfAllProducts.getListOfAllProducts() != null) {
            System.out.println(getListOfAllProducts.getListOfAllProducts());
        } else {
            System.out.println("List is empty, please add an item: ");
        }
    }
}