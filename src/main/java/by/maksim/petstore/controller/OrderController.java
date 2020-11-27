package by.maksim.petstore.controller;

import by.maksim.petstore.entity.Order;
import by.maksim.petstore.service.inDB.OrderService;
import by.maksim.petstore.service.inMemory.InMemoryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private InMemoryOrderService inMemoryOrderService;

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/order")
    public ResponseEntity<Boolean> addOrder(@Valid @RequestBody Order order) {
        if (order.getId() <= 10) {
            if (order.getId() >= 1) {
                if (orderService.addOrder(order)) {
                    return new ResponseEntity<>(HttpStatus.ACCEPTED);
                } else {
                    return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
                }
            }
        }
        return null;
    }

    @GetMapping(path = "findById")
    public ResponseEntity<Order> findById(@RequestParam int id) {
        Order orderById = orderService.getOrderById(id);
        if (orderById != null) {
            return new ResponseEntity<>(orderById,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping(path = "/deleteBy")
    public ResponseEntity<Boolean> deleteOrderById(@RequestParam int id) {
        if (orderService.deleteOrderById(id)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/inventory")
    public List<Order> getAll() {
        return orderService.getAll();
    }
}
