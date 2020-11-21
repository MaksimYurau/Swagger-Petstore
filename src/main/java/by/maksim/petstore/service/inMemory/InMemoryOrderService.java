package by.maksim.petstore.service.inMemory;

import by.maksim.petstore.entity.Order;
import by.maksim.petstore.exception.OrderNotFoundException;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryOrderService {
    private List<Order> orders = new ArrayList<>();

    public boolean save(@Valid Order order) {
        return orders.add(order);
    }

    public Order findByID(long id) {
        Order order = null;
        for (Order value : orders) {
            if (value.getId() == id) {
                order = value;
                break;
            }
        }
        return order;
    }

    public boolean removeByID(long id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == id) {
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Order> getAll() {
        return orders;
    }
}
