package repository;

import domains.Order.Order;
import factories.Order.OrderFactory;
import repository.impl.OrderRepositoryImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class OrderRepositoryImplTest {

    OrderRepositoryImpl orderRepository;

    @Before
    public void setUp() throws Exception{
        orderRepository = OrderRepositoryImpl.getRepository();
    }

    @Test
    public void create(){

        Order order = OrderFactory.getOrder("10 April 2019", "3x blinds");
        orderRepository.create(order);

        Assert.assertNotNull(orderRepository.getAll());
    }

    @Test
    public void read(){
        try {
            Order order = OrderFactory.getOrder("10 April 2019", "3x blinds");
            orderRepository.create(order);

            Assert.assertNotNull(orderRepository.getAll());
            System.out.println(order);

            Order order1 = orderRepository.read(Integer.parseInt(order.getOrderId()));
            Assert.assertEquals(order, order1);
        }
        catch (NumberFormatException nfe){
            System.out.println(nfe);
        }

    }

    @Test
    public void update(){

        Order order = OrderFactory.getOrder("10 April 2019", "3x blinds");
        orderRepository.create(order);

        Assert.assertNotNull(orderRepository.getAll());
        Order order1 = OrderFactory.getOrder("11 April 2019", "6x blinds");
        order1.setOrderId(order.getOrderId());
        orderRepository.update(order1);

        Order updatedOrder = orderRepository.find(order1.getOrderId());
        Assert.assertEquals(order1, updatedOrder);

        System.out.println(updatedOrder);

    }

    @Test
    public void delete(){
        try {
            Order order = OrderFactory.getOrder("10 April 2019", "3x blinds");
            orderRepository.create(order);

            Assert.assertNotNull(orderRepository.getAll());
            orderRepository.delete(Integer.parseInt(order.getOrderId()));
            Order deleted = orderRepository.find(order.getOrderId());
            Assert.assertNull(deleted);

            System.out.println(deleted);
        }
        catch (NumberFormatException nfe)
        {
            System.out.println(nfe);
        }


    }
}
