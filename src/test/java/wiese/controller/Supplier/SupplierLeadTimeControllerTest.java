package wiese.controller.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Supplier.SupplierLeadTime;
import wiese.factories.Supplier.SupplierLeadTimeFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SupplierLeadTimeControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/supplierLeadTime";

    @Test
    public void create() {
        SupplierLeadTime supplierLeadTime = SupplierLeadTimeFactory.getSupplierLeadTime();
        supplierLeadTime.setLeadTimeId(supplierLeadTime.getLeadTimeId());

        ResponseEntity<SupplierLeadTime> postResponse = restTemplate.postForEntity(baseURL + "/create", supplierLeadTime, SupplierLeadTime.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(supplierLeadTime.getLeadTimeId());
    }

    @Test
    public void findId() {
        SupplierLeadTime supplierLeadTime = restTemplate.getForObject(baseURL + "/supplierLeadTime/1", SupplierLeadTime.class);
        assertNotNull(supplierLeadTime);
        System.out.println(supplierLeadTime.getLeadTimeId());
    }

    @Test
    public void update() {
        int id = 1;
        SupplierLeadTime supplierLeadTime = restTemplate.getForObject(baseURL = "/supplierLeadTime/" + id, SupplierLeadTime.class);

        restTemplate.put(baseURL + "/supplierLeadTime/" + id, SupplierLeadTime.class);
        SupplierLeadTime updatedSupplierLeadTime = restTemplate.getForObject(baseURL + "/supplierLeadTime/" + id, SupplierLeadTime.class);
        assertNotNull(updatedSupplierLeadTime);
        System.out.println(updatedSupplierLeadTime);
    }

    @Test
    public void delete() {
        int id = 2;
        SupplierLeadTime supplierLeadTime = restTemplate.getForObject(baseURL = "/supplierLeadTime/" + id, SupplierLeadTime.class);
        assertNotNull(supplierLeadTime);
        restTemplate.put(baseURL + "/supplierLeadTime/" + id, SupplierLeadTime.class);
        try {
            supplierLeadTime = restTemplate.getForObject(baseURL + "/supplierLeadTime/" + id, SupplierLeadTime.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllSupplierLeadTimes() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}
