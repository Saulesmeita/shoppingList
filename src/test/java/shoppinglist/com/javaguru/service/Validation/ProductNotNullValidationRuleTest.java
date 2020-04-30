package shoppinglist.com.javaguru.service.Validation;

import org.junit.Test;
import shoppinglist.com.javaguru.domain.Product;
import shoppinglist.com.javaguru.service.validation.ProductNotNullValidationRule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductNotNullValidationRuleTest {

    ProductNotNullValidationRule validationRule = new ProductNotNullValidationRule();
    Product victim = null;

    @Test
    public void productIsNull() throws Exception {
        try {
            validationRule.validate(victim);
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Product must be not null");
        }
    }

}