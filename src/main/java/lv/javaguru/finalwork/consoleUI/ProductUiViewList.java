/*
package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.GetListOfAllProducts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductUiViewList {

    private GetListOfAllProducts getListOfAllProducts;

    @Autowired
    public ProductUiViewList(GetListOfAllProducts getListOfAllProducts) {
        this.getListOfAllProducts = getListOfAllProducts;
    }

    public void viewList() {
        System.out.println("There is list of products");
        if (getListOfAllProducts.getListOfAllProducts() != null) {
            System.out.println(getListOfAllProducts.getListOfAllProducts());
        } else {
            System.out.println("List is empty, please add an item: ");
        }
    }
}*/
