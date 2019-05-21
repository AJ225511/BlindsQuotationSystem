package wiese.controller.Product;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Product.Product;
import wiese.factories.Product.ProductFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ProductControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/product";

    @Test
    public void create(){
        Product product = ProductFactory.getProduct("Venetian");
        product.setProductId(product.getProductId());

        ResponseEntity<Product> postResponse = restTemplate.postForEntity(baseURL + "/create", product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(product);
    }

    @Test
    public void findId(){
        Product product = restTemplate.getForObject(baseURL + "/product/1", Product.class);
        assertNotNull(product);
        System.out.println(product.getProductId());
    }

    @Test
    public void update(){
        int id = 1;
        Product product = restTemplate.getForObject(baseURL = "/product/"+id, Product.class);

        restTemplate.put(baseURL + "/product/" + id, Product.class);
        Product updatedProduct = restTemplate.getForObject(baseURL + "/product/" +id, Product.class);
        assertNotNull(updatedProduct);
        System.out.println(updatedProduct);
    }

    @Test
    public void delete(){
        int id = 2;
        Product product = restTemplate.getForObject(baseURL = "/product/"+id, Product.class);
        assertNotNull(product);
        restTemplate.put(baseURL + "/product/" + id, Product.class);
        try{
            product = restTemplate.getForObject(baseURL + "/product/" +id, Product.class);
        }
        catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllProducts(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}
