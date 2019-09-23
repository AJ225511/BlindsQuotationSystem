package wiese.factories.Order;

import wiese.domains.Order.Order;
import wiese.util.Misc;

public class OrderFactory {

    public static Order getOrder(String orderDate, String orderItems) {
        return new Order.Builder()
                .orderDate(orderDate)
                .orderItems(orderItems)
                .orderId(Misc.generateId())
                .build();
    }
}
