package by.maksim.petstore.service.inDB;

import by.maksim.petstore.entity.Order;
import by.maksim.petstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean addOrder(Order order) {
        orderRepository.save(order);
        return true;
    }

    public Order getOrderById(int id) {
        Order one = orderRepository.getOne((long) id);
        return one;
    }

    public boolean deleteOrderById(int id) {
        orderRepository.deleteById((long) id);
        return true;
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
