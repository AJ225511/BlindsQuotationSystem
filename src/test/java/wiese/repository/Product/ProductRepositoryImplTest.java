package wiese.repository.Product;

import wiese.domains.Product.Product;
import wiese.factories.Product.ProductFactory;
import wiese.repository.impl.ProductRepositoryImpl;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.JVM)

public class ProductRepositoryImplTest {

    @Autowired
    private ProductRepositoryImpl productRepository;
    private String clientId = null;

    @Test
    public void create(){

        Product product = ProductFactory.getProduct("Venitian Blinds");
        productRepository.create(product);

        Assert.assertNotNull(productRepository.getAll());
    }

    @Test
    public void read(){
        try {
            Product product = ProductFactory.getProduct("Venitian Blinds");
            productRepository.create(product);

            Assert.assertNotNull(productRepository.getAll());
            System.out.println(product);

            Product product1 = productRepository.read(Integer.parseInt(product.getProductId()));
            Assert.assertEquals(product, product1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update(){

        Product product = ProductFactory.getProduct("Venitian Blinds");
        productRepository.create(product);

        Assert.assertNotNull(productRepository.getAll());
        Product product1 = ProductFactory.getProduct("Classic Wooden Blinds");
        product1.setProductId(product.getProductId());
        productRepository.update(product1);

        Product updatedProduct = productRepository.find(product1.getProductId());
        Assert.assertEquals(product1, updatedProduct);

        System.out.println(updatedProduct);

    }

    @Test
    public void delete(){
        try {
            Product product = ProductFactory.getProduct("Venitian Blinds");
            productRepository.create(product);

            Assert.assertNotNull(productRepository.getAll());
            productRepository.delete(Integer.parseInt(product.getProductId()));
            Product deleted = productRepository.find(product.getProductId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
        }


    }
}

