package shoppinglist.com.javaguru.service.Validation;

import shoppinglist.com.javaguru.domain.Product;

import java.math.RoundingMode;

public class ProductPriceValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getPrice().setScale(2, RoundingMode.HALF_EVEN).signum() < 1) {
            throw new ProductValidationException("Price must be nonzero positive");
        }
    }

}