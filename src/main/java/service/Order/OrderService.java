package service.Order;

import domains.Order.Order;
import service.Service;

import java.util.HashSet;
import java.util.Set;

public interface OrderService extends Service<Order, Integer> {
    Set<Order> getAll();
}
