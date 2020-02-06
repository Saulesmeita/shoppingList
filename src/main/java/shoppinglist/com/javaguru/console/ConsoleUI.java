package shoppinglist.com.javaguru.console;

import shoppinglist.com.javaguru.domain.Product;
import shoppinglist.com.javaguru.repository.ProductsRepository;

import java.math.BigDecimal;
import java.util.Scanner;

public class ConsoleUI {

    public void execute() {

        while (true) {
            Scanner scanner = new Scanner(System.in);
            try {
                System.out.println("1. Create product");
                System.out.println("2. Find product by id");
                System.out.println("3. Exit");
                Integer userInput = Integer.valueOf(scanner.nextLine());
                switch (userInput) {
                    case 1:
                        createProduct();
                        break;
                    case 2:
                        findProductByID();
                        break;
                    case 3:
                        return;
                }
            } catch (Exception e) {
                System.out.println("Error! Please try again.");
                System.out.println(e.getMessage());
            }
        }
    }

    private void createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product name: ");
        String name = scanner.nextLine();
        System.out.println("Enter product description: ");
        String description = scanner.nextLine();
        System.out.println("Enter product category: ");
        String category = scanner.nextLine();
        System.out.println("Enter product price: ");
        BigDecimal price = new BigDecimal(scanner.nextLine());
        System.out.println("Enter discount: ");
        BigDecimal discount = new BigDecimal(scanner.nextLine());
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setCategory(category);
        product.setPrice(price);
        product.setDiscount(discount);

        System.out.println("Result: " + product.getId());
    }

    private void findProductByID() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter product id: ");
        long id = scanner.nextLong();
        Product findProductResult = ProductsRepository.findByID(id);
        System.out.println(findProductResult);

    }
}
