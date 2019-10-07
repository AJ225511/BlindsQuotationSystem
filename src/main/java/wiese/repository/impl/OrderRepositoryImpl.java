//package wiese.repository.impl;
//
//import org.springframework.stereotype.Repository;
//import wiese.domains.Order.Order;
//import wiese.repository.Order.OrderRepository;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Repository("OrderInMemory")
//public class OrderRepositoryImpl implements OrderRepository {
//
//    private static OrderRepositoryImpl repository = null;
//    private Set<Order> orders;
//
//    private OrderRepositoryImpl() {
//        this.orders = new HashSet<>();
//    }
//
//    public static OrderRepositoryImpl getRepository() {
//        if (repository == null) repository = new OrderRepositoryImpl();
//        return repository;
//    }
//
//    public Order find(String id) {
//        return orders.stream().filter(order -> order.getOrderId() == id).findAny().orElse(null);
//    }
//
//    @Override
//    public Set<Order> getAll() {
//        return orders;
//    }
//
//    @Override
//    public Order create(Order order) {
//        this.orders.add(order);
//        return order;
//    }
//
//    @Override
//    public Order update(Order order) {
//        Order order1 = find(order.getOrderId());
//        if (orders.contains(order1)) {
//            orders.remove(order1);
//            orders.add(order);
//        }
//        return order1;
//    }
//
//    @Override
//    public void delete(Integer id) {
//
//        Order order = find(Integer.toString(id));
//        orders.remove(order);
//
//    }
//
//    @Override
//    public Order read(Integer id) {
//        Order order = find(Integer.toString(id));
//        if (order == null) {
//            return null;
//        } else {
//            return order;
//        }
//    }
//}

