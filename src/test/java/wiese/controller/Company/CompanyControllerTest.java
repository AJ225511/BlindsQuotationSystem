package wiese.controller.Company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Company.Company;
import wiese.factories.Company.CompanyFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CompanyControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/company";

    @Test
    public void create(){
        Company company = CompanyFactory.getCompany("AJ's Steakhouse", "21 Bratton Way");
        company.setCompanyId(company.getCompanyId());

        ResponseEntity<Company> postResponse = restTemplate.postForEntity(baseURL + "/create", company, Company.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(company);
    }

    @Test
    public void findId(){
        Company company = restTemplate.getForObject(baseURL + "/company/1", Company.class);
        assertNotNull(company);
        System.out.println(company.getCompanyName());
    }

    @Test
    public void update(){
        int id = 1;
        Company company = restTemplate.getForObject(baseURL = "/company/"+id, Company.class);

        restTemplate.put(baseURL + "/company/" + id, Company.class);
        Company updatedCompany = restTemplate.getForObject(baseURL + "/company/" +id, Company.class);
        assertNotNull(updatedCompany);
        System.out.println(updatedCompany);
    }

    @Test
    public void delete(){
        int id = 2;
        Company company = restTemplate.getForObject(baseURL = "/company/"+id, Company.class);
        assertNotNull(company);
        restTemplate.put(baseURL + "/company/" + id, Company.class);
        try{
            company = restTemplate.getForObject(baseURL + "/company/" +id, Company.class);
        }
        catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllCompanys(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}