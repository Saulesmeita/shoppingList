package shoppinglist.com.javaguru.service.Validation;

import shoppinglist.com.javaguru.domain.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductValidationService {

    private Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductNameValidationRule());
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }
}
