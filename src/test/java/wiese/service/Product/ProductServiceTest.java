package wiese.service.Product;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Product.Product;
import wiese.factories.Product.ProductFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.ProductServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductServiceTest {
    @Autowired
    private ProductServiceImpl productService;

    @Test
    public void create(){
        Product product = ProductFactory.getProduct("Wooden Blinds");
        productService.create(product);

        assertNotNull(productService.getAll());
        System.out.println(product.getProductName());
    }

    @Test
    public void read(){
        try {
            Product product = ProductFactory.getProduct("Iron Blinds");
            productService.create(product);

            Product product1 = productService.read(Integer.parseInt(product.getProductId()));
            assertEquals(product, product1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            Product product = ProductFactory.getProduct("Wooden Blinds");
            productService.create(product);

            Product product1 = ProductFactory.getProduct("Venetian Blinds");
            product1.setProductId(product.getProductId());
            productService.update(product1);
            System.out.println("Original: \n"+product.getProductName());
            System.out.println("Updated: \n"+product1.getProductName());

            Product product2 = productService.read(Integer.parseInt(product1.getProductId()));
            assertEquals(product1, product2);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }
    @Test
    public void delete(){
        try {
            Product product = ProductFactory.getProduct("Steel shutters");
            productService.create(product);

            assertNotNull(productService.getAll());
            Product product1 = productService.read(Integer.parseInt(product.getProductId()));
            assertNull(product1);
        }catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }
}

