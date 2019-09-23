package wiese.domains.Product;

import java.util.Objects;

public class Product {

    private String productId, productName;

    public Product() {
    }

    public Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public static class Builder {

        private String productId, productName;

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Product build() {
            return new Product(this);
        }

        @Override
        public String toString() {
            return "Product{" +
                    "productId='" + productId + '\'' +
                    ", productName='" + productName + '\'' +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return productId.equals(product.productId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(productId);
        }
    }

}
