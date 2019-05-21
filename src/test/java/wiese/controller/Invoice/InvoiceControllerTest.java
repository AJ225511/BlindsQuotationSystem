package wiese.controller.Invoice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Invoice.Invoice;
import wiese.factories.Invoice.InvoiceFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class InvoiceControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/invoice";

    @Test
    public void create(){
        Invoice invoice = InvoiceFactory.getInvoice("14 June 2019", "1x Venetian Blinds");
        invoice.setInvoiceId(invoice.getInvoiceId());

        ResponseEntity<Invoice> postResponse = restTemplate.postForEntity(baseURL + "/create", invoice, Invoice.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(invoice);
    }

    @Test
    public void findId(){
        Invoice invoice = restTemplate.getForObject(baseURL + "/invoice/1", Invoice.class);
        assertNotNull(invoice);
        System.out.println(invoice.getInvoiceId());
    }

    @Test
    public void update(){
        int id = 1;
        Invoice invoice = restTemplate.getForObject(baseURL = "/invoice/"+id, Invoice.class);

        restTemplate.put(baseURL + "/invoice/" + id, Invoice.class);
        Invoice updatedInvoice = restTemplate.getForObject(baseURL + "/invoice/" +id, Invoice.class);
        assertNotNull(updatedInvoice);
        System.out.println(updatedInvoice);
    }

    @Test
    public void delete(){
        int id = 2;
        Invoice invoice = restTemplate.getForObject(baseURL = "/invoice/"+id, Invoice.class);
        assertNotNull(invoice);
        restTemplate.put(baseURL + "/invoice/" + id, Invoice.class);
        try{
            invoice = restTemplate.getForObject(baseURL + "/invoice/" +id, Invoice.class);
        }
        catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllInvoices(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}
