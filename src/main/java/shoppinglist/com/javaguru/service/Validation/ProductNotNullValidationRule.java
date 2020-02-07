package shoppinglist.com.javaguru.service.Validation;

import shoppinglist.com.javaguru.domain.Product;

public class ProductNotNullValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {

        if (product == null) {
            throw new ProductValidationException("Product must be not null");
        }

    }
}
