package lv.javaguru.finalwork;

import lv.javaguru.finalwork.ui.ProductMainUI;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args){

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        ProductMainUI ui = applicationContext.getBean(ProductMainUI.class);
        ui.execute();
    }
}