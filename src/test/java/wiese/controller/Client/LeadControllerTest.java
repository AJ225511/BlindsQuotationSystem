package wiese.controller.Client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Client.Lead;
import wiese.factories.Client.LeadFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class LeadControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/lead";

    @Test
    public void create(){
        Lead lead = LeadFactory.getLead("21 April 2019");
        lead.setLeadId(lead.getLeadId());

        ResponseEntity<Lead> postResponse = restTemplate.postForEntity(baseURL + "/create", lead, Lead.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(lead);
    }

    @Test
    public void findId(){
        Lead lead = restTemplate.getForObject(baseURL + "/lead/1", Lead.class);
        assertNotNull(lead);
        System.out.println(lead.getLeadId());
    }

    @Test
    public void update(){
        int id = 1;
        Lead lead = restTemplate.getForObject(baseURL = "/lead/"+id, Lead.class);

        restTemplate.put(baseURL + "/lead/" + id, Lead.class);
        Lead updatedLead = restTemplate.getForObject(baseURL + "/lead/" +id, Lead.class);
        assertNotNull(updatedLead);
        System.out.println(updatedLead);
    }

    @Test
    public void delete(){
        int id = 2;
        Lead lead = restTemplate.getForObject(baseURL = "/lead/"+id, Lead.class);
        assertNotNull(lead);
        restTemplate.put(baseURL + "/lead/" + id, Lead.class);
        try{
            lead = restTemplate.getForObject(baseURL + "/lead/" +id, Lead.class);
        }
        catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllLeads(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}
