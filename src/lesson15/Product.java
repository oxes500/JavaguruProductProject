package lesson15;

import java.math.BigDecimal;

public class Product {

    private long id;
    private String name;
    private BigDecimal price;
    enum Category{FRUIT, VEGETABLES, DRINK, MEAT, FISH, SNACKS}
    private BigDecimal discount;
    private String description;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    public Product(long id, String name, BigDecimal price, BigDecimal discount, String description) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.discount = discount;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (discount != null ? !discount.equals(product.discount) : product.discount != null) return false;
        return description != null ? description.equals(product.description) : product.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", discount=" + discount +
                ", description='" + description + '\'' +
                '}';
    }
}
