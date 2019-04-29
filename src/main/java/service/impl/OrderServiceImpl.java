package service.impl;

import domains.Order.Order;
import repository.Order.OrderRepository;
import repository.impl.OrderRepositoryImpl;
import service.Order.OrderService;

import java.util.Set;

public class OrderServiceImpl implements OrderService {

    private OrderServiceImpl service = null;
    private OrderRepository repository;
    private Integer id;

    public OrderServiceImpl(){
        repository = OrderRepositoryImpl.getRepository();
    }

    public OrderService getService(){
        if(service == null) service = new OrderServiceImpl();
        return service;
    }

    @Override
    public Set<Order> getAll() {
        return this.repository.getAll();
    }

    @Override
    public Order create(Order order) {
        return this.repository.create(order);
    }

    @Override
    public Order update(Order order) {
        return this.repository.update(order);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.delete(id);
    }

    @Override
    public Order read(Integer integer) {
        return this.repository.read(id);
    }
}
