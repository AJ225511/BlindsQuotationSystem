package wiese.factory.Product;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Product.Product;
import wiese.factories.Product.ProductFactory;

public class ProductFactoryTest {
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void getProduct() {

        Product product = ProductFactory.getProduct("Venetian Blinds");
        Assert.assertNotNull(product.getProductId());
        System.out.println(product.getProductName());
    }
}

