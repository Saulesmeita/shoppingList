package shoppinglist.com.javaguru.service.Validation;

import org.junit.Test;
import shoppinglist.com.javaguru.domain.Product;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductPriceValidationRuleTest {

    ProductPriceValidationRule validationRule = new ProductPriceValidationRule();
    Product victim = new Product();

    @Test
    public void setPriceZero() throws Exception {
        victim.setPrice(new BigDecimal("0.00"));
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Price must be nonzero positive");
        }
    }

    @Test
    public void setPriceNegative() throws Exception {
        victim.setPrice(new BigDecimal("-5"));
        try {
            validationRule.validate(victim);
            fail();
        } catch (ProductValidationException e) {
            assertEquals(e.getMessage(), "Price must be nonzero positive");
        }
    }

    @Test
    public void setPricePositive() throws Exception {
        victim.setPrice(new BigDecimal("0.01"));
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

}