package wiese.factories.Product;

import wiese.domains.Product.Product;
import wiese.util.Misc;

public class ProductFactory {

    public static Product getProduct(String productName){
        return new Product.Builder()
                .productName(productName)
                .productId(Misc.generateId())
                .build();
    }
}
