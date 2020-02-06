package shoppinglist.com.javaguru;

import org.junit.Before;
import org.junit.Test;
import shoppinglist.com.javaguru.domain.Product;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ProductTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void setDescription() {

    }

    @Test
    public void setDiscount() {
    }

    @Test
    public void setName() {
    }

    @Test
    public void setPriceZero() throws Exception {
        Product victim = new Product();
        try {
            victim.setPrice(new BigDecimal("0"));
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Price must be nonzero positive");
        }
    }

    @Test
    public void setPriceNegative() throws Exception {
        Product victim = new Product();
        try {
            victim.setPrice(new BigDecimal("-5"));
            fail();
        } catch (Exception e) {
            assertEquals(e.getMessage(), "Price must be nonzero positive");
        }
    }

    @Test
    public void setPricePositive() throws Exception {
        Product victim = new Product();
        try {
            victim.setPrice(new BigDecimal("0.01"));
            assertEquals(victim.getPrice(), new BigDecimal("0.01"));
        } catch (Exception e) {
            fail();
        }
    }

}