package shoppinglist.com.javaguru.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    private Long id;
    private String name;
    private BigDecimal price;
    private String category;
    private String description;
    private BigDecimal discount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) throws Exception {
        if (name.length() >= 3 && name.length() <= 32) {
            this.name = name;
        } else {
            throw new Exception("The name cannot be shorter than 3 symbols or longer than 32 symbols");
        }
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws Exception {
        if (price.signum() == 1) {
            this.price = price;
        } else {
            throw new Exception("Price must be nonzero positive");
        }
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) throws Exception {
        if (discount.compareTo(price) <= 0) {
            this.discount = discount;
        } else {
            throw new Exception("The discount cannot exceed the price");
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getId().equals(product.getId()) &&
                getName().equals(product.getName()) &&
                getPrice().equals(product.getPrice()) &&
                getCategory().equals(product.getCategory()) &&
                Objects.equals(getDescription(), product.getDescription()) &&
                Objects.equals(getDiscount(), product.getDiscount());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPrice());
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", discount=" + discount +
                '}';
    }
}