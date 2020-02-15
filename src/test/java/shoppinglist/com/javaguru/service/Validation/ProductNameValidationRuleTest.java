package shoppinglist.com.javaguru.service.Validation;

import org.junit.Test;
import shoppinglist.com.javaguru.domain.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductNameValidationRuleTest {

    ProductNameValidationRule validationRule = new ProductNameValidationRule();
    Product victim = new Product();

    @Test
    public void nameTooLong() throws Exception {
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
        victim.setName("12345678901234567890123456789012");
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void nameIsValidLoverBorder() throws Exception {
        victim.setName("mMm");
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void nameIsValidMiddle() throws Exception {
        victim.setName("Just a name");
        try {
            validationRule.validate(victim);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void nameIsNull() throws Exception {
        victim.setName(null);
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Product name must be not null.");
        }
    }

}