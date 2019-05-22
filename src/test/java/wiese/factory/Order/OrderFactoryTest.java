package wiese.factory.Order;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import wiese.domains.Order.Order;
import wiese.factories.Order.OrderFactory;

public class OrderFactoryTest {
    @Before
    public void setUp() throws Exception{

    }
    @Test
    public void getOrder(){

        Order order = OrderFactory.getOrder("12 May 2019", "1x Iron Shutters");
        Assert.assertNotNull(order.getOrderId());
        System.out.println(order.getOrderItems());
    }
}
