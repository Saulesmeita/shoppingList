package shoppinglist.com.javaguru.dihelper;

import shoppinglist.com.javaguru.console.ConsoleUI;
import shoppinglist.com.javaguru.repository.ProductsRepository;
import shoppinglist.com.javaguru.service.ProductService;
import shoppinglist.com.javaguru.service.Validation.ProductValidationService;

public class DIHelper {

    public static ConsoleUI createApplication() {

        ProductsRepository productRepository = new ProductsRepository();
        ProductValidationService validationService = new ProductValidationService();

        ProductService productService = new ProductService(productRepository, validationService);
        return new ConsoleUI(productService);
    }

}
