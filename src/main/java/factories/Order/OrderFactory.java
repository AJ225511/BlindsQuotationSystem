package factories.Order;

import domains.Order.Order;
import util.Misc;

public class OrderFactory {

    public static Order getOrder(String orderDate, String orderItems){
        return new Order.Builder()
                .orderDate(orderDate)
                .orderItems(orderItems)
                .orderId(Misc.generateId())
                .build();
    }
}
