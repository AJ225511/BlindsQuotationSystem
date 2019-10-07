package wiese.domains.Product;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Objects;

public class Product {

    @Id
    private String productId,productName;
    @OneToMany()
    private String desc;

    public Product() {
    }

    public Product(Builder builder) {
        this.productId = builder.productId;
        this.productName = builder.productName;
        this.desc = builder.desc;
    }

    public String getProductId() {
        return productId;
    }

    public String getDesc(){
        return desc;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                "productName='" + productName + '\'' +
                "desc='" + desc + '\'' +
                '}';
    }

    public static class Builder {

        private String productId,productName, desc;

        public Builder productId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public Builder desc(String desc){
            this.desc = desc;
            return this;
        }

        public Builder copy(Product product){
            this.productId = product.productId;
            this.productName=product.productName;
            this.desc = product.desc;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }

}
