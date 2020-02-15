package shoppinglist.com.javaguru.service.Validation;

import org.junit.Test;
import shoppinglist.com.javaguru.domain.Product;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductDiscountValidationRuleTest {

    ProductDiscountValidationRule validationRule = new ProductDiscountValidationRule();
    Product victim = new Product();

    @Test
    public void discountExceedsPrice() throws Exception {

        victim.setPrice(new BigDecimal("30.0"));
        victim.setDiscount(new BigDecimal("100.01"));
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "The discount cannot exceed the price");
        }
    }

    @Test
    public void discountDoesNotExceedPrice() throws Exception {

        victim.setPrice(new BigDecimal("30.0"));
        victim.setDiscount(new BigDecimal("100.00"));
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void discountIsNegative() throws Exception {

        victim.setPrice(new BigDecimal("50.0"));
        victim.setDiscount(new BigDecimal("-12.5"));
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "The discount cannot be negative");
        }
    }

    @Test
    public void discountPositive() throws Exception {

        victim.setPrice(new BigDecimal("55"));
        victim.setDiscount(new BigDecimal("7.8"));
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void discountZero() throws Exception {

        victim.setPrice(new BigDecimal("55"));
        victim.setDiscount(new BigDecimal("0.00"));
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }


}