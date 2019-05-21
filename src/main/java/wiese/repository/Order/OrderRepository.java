package wiese.repository.Order;

import wiese.domains.Order.Order;
import wiese.repository.Repository;

import java.util.Set;

public interface OrderRepository extends Repository <Order, Integer> {
    Set<Order> getAll();
}
