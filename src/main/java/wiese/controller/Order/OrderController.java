package wiese.controller.Order;

import wiese.domains.Order.Order;
import wiese.service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    @Qualifier("OrderServiceImpl")
    private OrderServiceImpl orderService;

    @PostMapping("/create")
    public Order create(@RequestBody Order order) {
        return orderService.create(order);
    }

    @PostMapping("/update")
    public Order order(@RequestBody Order order) {
        return orderService.update(order);
    }

    @GetMapping("/delete/{id}")
    @ResponseBody
    public void delete(@PathVariable String id) {
        orderService.delete(id);
    }

    @GetMapping("/read/{id}")
    @ResponseBody
    public Order read(@PathVariable String id) {
        return orderService.read(id);
    }

    @GetMapping("read/all")
    @ResponseBody
    public List<Order> getAll() {
        return orderService.getAll();
    }

}
