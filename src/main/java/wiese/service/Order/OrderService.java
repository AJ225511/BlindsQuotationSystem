package wiese.service.Order;

import wiese.domains.Order.Order;
import wiese.service.Service;

import java.util.List;
import java.util.Set;

public interface OrderService extends Service<Order, String> {
    Order retrieveByDesc(String orderDesc);
    List<Order> getAll();
}
