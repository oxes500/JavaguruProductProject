package FinalWork.ui;

public class ProductUI {

    public static void main(String[] args) throws NumberFormatException{
        ProductMainUI productMainUI = new ProductMainUI();
        while (true) {
            try {
                productMainUI.mainUI();
            } catch (NumberFormatException e) {
                System.out.println("Please enter value and press ENTER");
                productMainUI.mainUI();
            }
        }
    }
}
