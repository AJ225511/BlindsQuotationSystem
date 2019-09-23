package wiese.controller.Order;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import wiese.domains.Order.Order;
import wiese.factories.Order.OrderFactory;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class OrderControllerTest {
    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURL = "http://localhost:8080/order";

    @Test
    public void create() {
        Order order = OrderFactory.getOrder("11 June 2019", "4x Venetian Blinds");
        order.setOrderId(order.getOrderId());

        ResponseEntity<Order> postResponse = restTemplate.postForEntity(baseURL + "/create", order, Order.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        System.out.println(order);
    }

    @Test
    public void findId() {
        Order order = restTemplate.getForObject(baseURL + "/order/1", Order.class);
        assertNotNull(order);
        System.out.println(order.getOrderId());
    }

    @Test
    public void update() {
        int id = 1;
        Order order = restTemplate.getForObject(baseURL = "/order/" + id, Order.class);

        restTemplate.put(baseURL + "/order/" + id, Order.class);
        Order updatedOrder = restTemplate.getForObject(baseURL + "/order/" + id, Order.class);
        assertNotNull(updatedOrder);
        System.out.println(updatedOrder);
    }

    @Test
    public void delete() {
        int id = 2;
        Order order = restTemplate.getForObject(baseURL = "/order/" + id, Order.class);
        assertNotNull(order);
        restTemplate.put(baseURL + "/order/" + id, Order.class);
        try {
            order = restTemplate.getForObject(baseURL + "/order/" + id, Order.class);
        } catch (final HttpClientErrorException e) {
            assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
        }
    }

    @Test
    public void testGetAllOrders() {
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(baseURL + "/create", HttpMethod.GET, entity, String.class);
        assertNotNull(response.getBody());
    }

}

