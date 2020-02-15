package shoppinglist.com.javaguru.service.Validation;

import shoppinglist.com.javaguru.domain.Product;

public class ProductNameValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getName() == null) {
            throw new ProductValidationException("Product name must be not null.");
        } else {
            if (product.getName().length() < 3 || product.getName().length() > 32) {
                throw new ProductValidationException("The name cannot be shorter than 3 symbols or longer than 32 symbols");
            }
        }
    }

}
