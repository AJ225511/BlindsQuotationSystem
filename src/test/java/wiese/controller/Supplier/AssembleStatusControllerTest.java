package wiese.controller.Supplier;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Supplier.AssembleStatus;
import wiese.factories.Supplier.AssembleStatusFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class AssembleStatusControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/assembleStatus";

    @Test
    public void create(){
        AssembleStatus assembleStatus = AssembleStatusFactory.getAssembleStatus();
        assembleStatus.setAssembleStatusId(assembleStatus.getAssembleStatusId());

        ResponseEntity<AssembleStatus> postResponse = restTemplate.postForEntity(baseURL + "/create", assembleStatus, AssembleStatus.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(assembleStatus.getAssembleStatusId());
    }

    @Test
    public void findId(){
        AssembleStatus assembleStatus = restTemplate.getForObject(baseURL + "/assembleStatus/1", AssembleStatus.class);
        assertNotNull(assembleStatus);
        System.out.println(assembleStatus.getAssembleStatusId());
    }

    @Test
    public void update(){
        int id = 1;
        AssembleStatus assembleStatus = restTemplate.getForObject(baseURL = "/assembleStatus/"+id, AssembleStatus.class);

        restTemplate.put(baseURL + "/assembleStatus/" + id, AssembleStatus.class);
        AssembleStatus updatedAssembleStatus = restTemplate.getForObject(baseURL + "/assembleStatus/" +id, AssembleStatus.class);
        assertNotNull(updatedAssembleStatus);
        System.out.println(updatedAssembleStatus);
    }

    @Test
    public void delete(){
        int id = 2;
        AssembleStatus assembleStatus = restTemplate.getForObject(baseURL = "/assembleStatus/"+id, AssembleStatus.class);
        assertNotNull(assembleStatus);
        restTemplate.put(baseURL + "/assembleStatus/" + id, AssembleStatus.class);
        try{
            assembleStatus = restTemplate.getForObject(baseURL + "/assembleStatus/" +id, AssembleStatus.class);
        }
        catch (final HttpClientErrorException e){
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllAssembleStatuss(){
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}
