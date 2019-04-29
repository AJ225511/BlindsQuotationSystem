package repository.Order;

import domains.Order.Order;
import repository.Repository;

import java.util.HashSet;
import java.util.Set;

public interface OrderRepository extends Repository <Order, Integer> {
    Set<Order> getAll();
}
