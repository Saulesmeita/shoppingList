package shoppinglist.com.javaguru;

import shoppinglist.com.javaguru.console.ConsoleUI;
import shoppinglist.com.javaguru.dihelper.DIHelper;

class ShoppingListApplication {

    public static void main(String[] args) {

        ConsoleUI consoleUI = DIHelper.createApplication();
        consoleUI.execute();
    }
}
