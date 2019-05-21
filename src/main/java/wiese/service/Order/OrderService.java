package wiese.service.Order;

import wiese.domains.Order.Order;
import wiese.service.Service;

import java.util.Set;

public interface OrderService extends Service<Order, Integer> {
    Set<Order> getAll();
}
