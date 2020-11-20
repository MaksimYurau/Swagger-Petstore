package by.maksim.petstore.service.inDB;

import by.maksim.petstore.entity.Order;
import by.maksim.petstore.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(@Valid Order order) {
        orderRepository.save(order);
        return order;
    }

    public Optional<Order> getOrderByOrderId(int orderId) {
        return orderRepository.findById((long) orderId);
    }

    public ResponseEntity<Void> deleteOrder(int orderId) {
        Order order = orderRepository.findById((long) orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderRepository.delete(order);
        return ResponseEntity.ok().build();
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }
}
