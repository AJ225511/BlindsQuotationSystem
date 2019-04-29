package repository;

import domains.Product.Product;
import factories.Product.ProductFactory;
import repository.impl.ProductRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductRepositoryImplTest {

    ProductRepositoryImpl productRepository;

    @Before
    public void setUp() throws Exception{
        productRepository = ProductRepositoryImpl.getRepository();
    }

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

