package shoppinglist.com.javaguru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.com.javaguru.domain.Product;
import shoppinglist.com.javaguru.repository.ProductsRepository;
import shoppinglist.com.javaguru.service.validation.ProductValidationService;

@Component
public class ProductService {

    private final ProductsRepository repository;
    private final ProductValidationService validationService;

    @Autowired
    public ProductService(ProductsRepository repository, ProductValidationService validationService) {
        this.repository = repository;
        this.validationService = validationService;
    }

    public Long createProduct(Product product) {
        validationService.validate(product);
        Product createdProduct = repository.add(product);
        return createdProduct.getId();
    }

    public Product findProductById(Long id) {
        return repository.findByID(id);
    }
}
