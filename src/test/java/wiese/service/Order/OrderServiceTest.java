package wiese.service.Order;

import org.springframework.beans.factory.annotation.Autowired;
import wiese.domains.Order.Order;
import wiese.factories.Order.OrderFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import wiese.service.impl.OrderServiceImpl;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderServiceTest {
    @Autowired
    private OrderServiceImpl orderService;

    @Test
    public void create(){
        Order order = OrderFactory.getOrder("12 May 2019", "1x Venetian Blinds");
        orderService.create(order);

        assertNotNull(orderService.getAll());
        System.out.println(order);
    }

    @Test
    public void read(){
        try {
            Order order = OrderFactory.getOrder("12 May 2019", "1x Venetian Blinds");
            orderService.create(order);

            Order order1 = orderService.read(Integer.parseInt(order.getOrderId()));
            assertEquals(order, order1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update() {
        try {
            Order order = OrderFactory.getOrder("11 May 2019", "2x Venetian Blinds");
            orderService.create(order);

            Order order1 = OrderFactory.getOrder("15 May 2019", "5x Venetian Blinds");
            order1.setOrderId(order.getOrderId());
            orderService.update(order1);
            System.out.println("Original: \n"+order);
            System.out.println("Updated: \n"+order1);

            Order order2 = orderService.read(Integer.parseInt(order1.getOrderId()));
            assertEquals(order1, order2);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }
    @Test
    public void delete(){
        try {
            Order order = OrderFactory.getOrder("22 May 2019", "3x Venetian Blinds");
            orderService.create(order);

            assertNotNull(orderService.getAll());
            Order order1 = orderService.read(Integer.parseInt(order.getOrderId()));
            assertNull(order1);
        }catch (NumberFormatException nfe){
            System.out.println(nfe);
        }
    }
}
