package shoppinglist.com.javaguru.repository;

import shoppinglist.com.javaguru.domain.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductsRepository {

    private Map<Long, Product> productRepository = new HashMap<>();
    private Long productIdSequence = 0L;

    public Product add(Product product) {
        product.setId(productIdSequence);
        productRepository.put(productIdSequence++, product);
        return product;
    }

    public Product findByID(Long id) {
        return productRepository.get(id);
    }

}
