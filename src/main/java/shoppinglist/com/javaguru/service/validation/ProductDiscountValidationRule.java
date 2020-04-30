package shoppinglist.com.javaguru.service.validation;

import org.springframework.stereotype.Component;
import shoppinglist.com.javaguru.domain.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class ProductDiscountValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {
        if (product.getDiscount().setScale(2, RoundingMode.HALF_EVEN).compareTo(new BigDecimal(100.00)) == 1) {
            throw new ProductValidationException("The discount cannot exceed the price");
        } else {
            if (product.getDiscount().setScale(2, RoundingMode.HALF_EVEN).signum() == -1) {
                throw new ProductValidationException("The discount cannot be negative");
            }
        }
    }
}
