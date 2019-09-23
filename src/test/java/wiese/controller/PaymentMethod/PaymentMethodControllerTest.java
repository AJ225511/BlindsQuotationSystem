package wiese.controller.PaymentMethod;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.PaymentMethod.PaymentMethod;
import wiese.factories.PaymentMethod.PaymentMethodFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class PaymentMethodControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/paymentMethod";

    @Test
    public void create() {
        PaymentMethod paymentMethod = PaymentMethodFactory.getPaymentMethod(600, "12 June 2019");
        paymentMethod.setPaymentId(paymentMethod.getPaymentId());

        ResponseEntity<PaymentMethod> postResponse = restTemplate.postForEntity(baseURL + "/create", paymentMethod, PaymentMethod.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(paymentMethod);
    }

    @Test
    public void findId() {
        PaymentMethod paymentMethod = restTemplate.getForObject(baseURL + "/paymentMethod/1", PaymentMethod.class);
        assertNotNull(paymentMethod);
        System.out.println(paymentMethod.getPaymentId());
    }

    @Test
    public void update() {
        int id = 1;
        PaymentMethod paymentMethod = restTemplate.getForObject(baseURL = "/paymentMethod/" + id, PaymentMethod.class);

        restTemplate.put(baseURL + "/paymentMethod/" + id, PaymentMethod.class);
        PaymentMethod updatedPaymentMethod = restTemplate.getForObject(baseURL + "/paymentMethod/" + id, PaymentMethod.class);
        assertNotNull(updatedPaymentMethod);
        System.out.println(updatedPaymentMethod);
    }

    @Test
    public void delete() {
        int id = 2;
        PaymentMethod paymentMethod = restTemplate.getForObject(baseURL = "/paymentMethod/" + id, PaymentMethod.class);
        assertNotNull(paymentMethod);
        restTemplate.put(baseURL + "/paymentMethod/" + id, PaymentMethod.class);
        try {
            paymentMethod = restTemplate.getForObject(baseURL + "/paymentMethod/" + id, PaymentMethod.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllPaymentMethods() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}
