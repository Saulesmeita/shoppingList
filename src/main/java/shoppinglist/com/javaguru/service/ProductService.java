package shoppinglist.com.javaguru.service;

import shoppinglist.com.javaguru.domain.Product;
import shoppinglist.com.javaguru.repository.ProductsRepository;
import shoppinglist.com.javaguru.service.Validation.ProductValidationService;

public class ProductService {

    private ProductsRepository repository = new ProductsRepository();
    private ProductValidationService validationService = new ProductValidationService();

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.add(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return repository.findByID(id);
    }
}
