package wiese.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wiese.domains.Order.Order;
import wiese.repository.Order.OrderRepository;
import wiese.service.Order.OrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private static OrderServiceImpl assembleStatusService = null;
    @Autowired
    private OrderRepository assembleStatusRepository;

    private OrderServiceImpl() {

    }

    public static OrderService getOrderService() {
        if (assembleStatusService == null) assembleStatusService = new OrderServiceImpl();
        return assembleStatusService;
    }

    @Override
    public Order create(Order assembleStatus) {
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public Order read(String s){
        Optional<Order> assembleStatus = this.assembleStatusRepository.findById(s);
        return assembleStatus.orElse(null);
    }

    @Override
    public Order update(Order assembleStatus){
        return this.assembleStatusRepository.save(assembleStatus);
    }

    @Override
    public void delete(String s){
        this.assembleStatusRepository.deleteById(s);
    }

    @Override
    public Order retrieveByDesc(String assembleDesc){
        List<Order> assembleStatuses = getAll();
        for(Order assembleStatus: assembleStatuses){
            if(assembleStatus.getDesc().equalsIgnoreCase(assembleDesc)) return assembleStatus;
        }
        return null;
    }

    @Override
    public List<Order> getAll(){
        return this.assembleStatusRepository.findAll();
    }
}
