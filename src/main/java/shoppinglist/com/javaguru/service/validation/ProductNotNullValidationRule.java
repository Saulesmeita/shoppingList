package shoppinglist.com.javaguru.service.validation;

import org.springframework.stereotype.Component;
import shoppinglist.com.javaguru.domain.Product;

@Component
public class ProductNotNullValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {

        if (product == null) {
            throw new ProductValidationException("Product must be not null");
        }

    }
}
