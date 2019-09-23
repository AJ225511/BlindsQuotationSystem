package wiese.controller.Quotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Quotation.Quotation;
import wiese.factories.Quotation.QuotationFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class QuotationControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/quotation";

    @Test
    public void create() {
        Quotation quotation = QuotationFactory.getQuotation("11 June 2019");
        quotation.setQuotationId(quotation.getQuotationId());

        ResponseEntity<Quotation> postResponse = restTemplate.postForEntity(baseURL + "/create", quotation, Quotation.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(quotation.getQuotationDate());
    }

    @Test
    public void findId() {
        Quotation quotation = restTemplate.getForObject(baseURL + "/quotation/1", Quotation.class);
        assertNotNull(quotation);
        System.out.println(quotation.getQuotationId());
    }

    @Test
    public void update() {
        int id = 1;
        Quotation quotation = restTemplate.getForObject(baseURL = "/quotation/" + id, Quotation.class);

        restTemplate.put(baseURL + "/quotation/" + id, Quotation.class);
        Quotation updatedQuotation = restTemplate.getForObject(baseURL + "/quotation/" + id, Quotation.class);
        assertNotNull(updatedQuotation);
        System.out.println(updatedQuotation);
    }

    @Test
    public void delete() {
        int id = 2;
        Quotation quotation = restTemplate.getForObject(baseURL = "/quotation/" + id, Quotation.class);
        assertNotNull(quotation);
        restTemplate.put(baseURL + "/quotation/" + id, Quotation.class);
        try {
            quotation = restTemplate.getForObject(baseURL + "/quotation/" + id, Quotation.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllQuotations() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}
