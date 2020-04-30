package shoppinglist.com.javaguru.service.Validation;

import org.junit.Test;
import shoppinglist.com.javaguru.domain.Product;
import shoppinglist.com.javaguru.service.validation.ProductDiscountAllowedValidationRule;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductDiscountAllowedValidationRuleTest {

    public ProductDiscountAllowedValidationRule validationRule = new ProductDiscountAllowedValidationRule();
    public Product victim = new Product();

    @Test
    public void discountNotAllowed() throws Exception {
        victim.setPrice(new BigDecimal("19.99"));
        victim.setDiscount(new BigDecimal("10"));
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "The discount is not applicable for products with the prices below 20$!");
        }
    }

    @Test
    public void discountAllowed() throws Exception {

        victim.setPrice(new BigDecimal("20.00"));
        victim.setDiscount(new BigDecimal("10"));
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }


}