package wiese.repository.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import wiese.domains.Order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
