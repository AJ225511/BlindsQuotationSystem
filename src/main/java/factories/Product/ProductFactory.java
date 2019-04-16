package factories.Product;

import domains.Product.Product;
import util.Misc;

public class ProductFactory {

    public static Product getProduct(String productName){
        return new Product.Builder()
                .productName(productName)
                .productId(Misc.generateId())
                .build();
    }
}
