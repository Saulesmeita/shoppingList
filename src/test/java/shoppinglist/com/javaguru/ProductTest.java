package shoppinglist.com.javaguru;

import org.junit.Before;
import org.junit.Test;
import shoppinglist.com.javaguru.domain.Product;
import shoppinglist.com.javaguru.service.Validation.*;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void setPriceZero() throws Exception {
        ProductPriceValidationRule validationRule = new ProductPriceValidationRule();
        Product victim = new Product();
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
        ProductPriceValidationRule validationRule = new ProductPriceValidationRule();
        Product victim = new Product();
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
        ProductPriceValidationRule validationRule = new ProductPriceValidationRule();
        Product victim = new Product();
        victim.setPrice(new BigDecimal("0.01"));
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void discountNotAllowed() throws Exception {
        ProductDiscountAllowedValidationRule validationRule = new ProductDiscountAllowedValidationRule();
        Product victim = new Product();
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
        ProductDiscountAllowedValidationRule validationRule = new ProductDiscountAllowedValidationRule();
        Product victim = new Product();
        victim.setPrice(new BigDecimal("20.00"));
        victim.setDiscount(new BigDecimal("10"));
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void discountExceedsPrice() throws Exception {
        ProductDiscountValidationRule validationRule = new ProductDiscountValidationRule();
        Product victim = new Product();
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
        ProductDiscountValidationRule validationRule = new ProductDiscountValidationRule();
        Product victim = new Product();
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
        ProductDiscountValidationRule validationRule = new ProductDiscountValidationRule();
        Product victim = new Product();
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
        ProductDiscountValidationRule validationRule = new ProductDiscountValidationRule();
        Product victim = new Product();
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
        ProductDiscountValidationRule validationRule = new ProductDiscountValidationRule();
        Product victim = new Product();
        victim.setPrice(new BigDecimal("55"));
        victim.setDiscount(new BigDecimal("0.00"));
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void nameTooLong() throws Exception {
        ProductNameValidationRule validationRule = new ProductNameValidationRule();
        Product victim = new Product();
        victim.setName("123456789012345678901234567890123");
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "The name cannot be shorter than 3 symbols or longer than 32 symbols");
        }
    }

    @Test
    public void nameTooShort() throws Exception {
        ProductNameValidationRule validationRule = new ProductNameValidationRule();
        Product victim = new Product();
        victim.setName("12");
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "The name cannot be shorter than 3 symbols or longer than 32 symbols");
        }
    }

    @Test
    public void nameIsValidUpperBorder() throws Exception {
        ProductNameValidationRule validationRule = new ProductNameValidationRule();
        Product victim = new Product();
        victim.setName("12345678901234567890123456789012");
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void nameIsValidLoverBorder() throws Exception {
        ProductNameValidationRule validationRule = new ProductNameValidationRule();
        Product victim = new Product();
        victim.setName("mMm");
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void nameIsValidMiddle() throws Exception {
        ProductNameValidationRule validationRule = new ProductNameValidationRule();
        Product victim = new Product();
        victim.setName("Just a name");
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void nameIsNull() throws Exception {
        ProductNameValidationRule validationRule = new ProductNameValidationRule();
        Product victim = new Product();
        victim.setName(null);
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Product name must be not null.");
        }
    }

    @Test
    public void productIsNull() throws Exception {
        ProductNotNullValidationRule validationRule = new ProductNotNullValidationRule();
        Product victim = new Product();
        victim = null;
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Product must be not null");
        }
    }
}