package wiese.controller.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Supplier.Supplier;
import wiese.factories.Supplier.SupplierFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SupplierControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/supplier";

    @Test
    public void create(){
        Supplier supplier = SupplierFactory.getSupplier("Bay View Blinds", "6 Camp Street");
        supplier.setSupplierId(supplier.getSupplierId());

        ResponseEntity<Supplier> postResponse = restTemplate.postForEntity(baseURL + "/create", supplier, Supplier.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(supplier.getSupplierName());
    }

    @Test
    public void findId(){
        Supplier supplier = restTemplate.getForObject(baseURL + "/supplier/1", Supplier.class);
        assertNotNull(supplier);
        System.out.println(supplier.getSupplierId());
    }

    @Test
    public void update(){
        int id = 1;
        Supplier supplier = restTemplate.getForObject(baseURL = "/supplier/"+id, Supplier.class);

        restTemplate.put(baseURL + "/supplier/" + id, Supplier.class);
        Supplier updatedSupplier = restTemplate.getForObject(baseURL + "/supplier/" +id, Supplier.class);
        assertNotNull(updatedSupplier);
        System.out.println(updatedSupplier);
    }

    @Test
    public void delete(){
        int id = 2;
        Supplier supplier = restTemplate.getForObject(baseURL = "/supplier/"+id, Supplier.class);
        assertNotNull(supplier);
        restTemplate.put(baseURL + "/supplier/" + id, Supplier.class);
        try{
            supplier = restTemplate.getForObject(baseURL + "/supplier/" +id, Supplier.class);
        }
        catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllSuppliers(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}
