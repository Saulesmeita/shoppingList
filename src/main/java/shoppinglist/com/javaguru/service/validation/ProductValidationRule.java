package shoppinglist.com.javaguru.service.validation;

import shoppinglist.com.javaguru.domain.Product;

public interface ProductValidationRule {

    void validate(Product product);

}
