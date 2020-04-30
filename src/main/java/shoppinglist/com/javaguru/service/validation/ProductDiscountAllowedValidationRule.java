package shoppinglist.com.javaguru.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import shoppinglist.com.javaguru.domain.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class ProductDiscountAllowedValidationRule implements ProductValidationRule {

    @Override
    public void validate(Product product) {

        if (product.getPrice().setScale(2, RoundingMode.HALF_EVEN).compareTo(new BigDecimal("20.00")) == -1) {
            if (product.getDiscount().setScale(2, RoundingMode.HALF_EVEN).signum() != 0) {
                throw new ProductValidationException("The discount is not applicable for products with the prices below 20$!");
            }
        }

    }
}
