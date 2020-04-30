package shoppinglist.com.javaguru.service.validation;

import org.springframework.stereotype.Component;
import shoppinglist.com.javaguru.domain.Product;

import java.util.HashSet;
import java.util.Set;

@Component
public class ProductValidationService {

    private final Set<ProductValidationRule> validationRules = new HashSet<>();

    public ProductValidationService() {
        validationRules.add(new ProductNotNullValidationRule());
        validationRules.add(new ProductNameValidationRule());
        validationRules.add(new ProductPriceValidationRule());
        validationRules.add(new ProductDiscountValidationRule());
        validationRules.add(new ProductDiscountAllowedValidationRule());
    }

    public void validate(Product product) {
        validationRules.forEach(s -> s.validate(product));
    }
}
