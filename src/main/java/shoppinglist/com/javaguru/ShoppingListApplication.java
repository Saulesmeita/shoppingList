package shoppinglist.com.javaguru;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import shoppinglist.com.javaguru.console.ConsoleUI;
import shoppinglist.com.javaguru.config.AppConfig;

class ShoppingListApplication {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                AppConfig.class
        );

        ConsoleUI consoleUI = context.getBean(ConsoleUI.class);
        consoleUI.execute();

        context.close();
    }
}
