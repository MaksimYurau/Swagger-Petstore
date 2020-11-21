package by.maksim.petstore.controller;

import by.maksim.petstore.entity.ApiResponse;
import by.maksim.petstore.entity.Order;
import by.maksim.petstore.service.inMemory.InMemoryOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/order")
public class OrderController {

    @Autowired
    private InMemoryOrderService inMemoryOrderService;

    @PostMapping
    public ApiResponse save(@Valid @RequestBody Order order) {
        ApiResponse apiResponse;
        if (inMemoryOrderService.save(order)) {
            apiResponse = new ApiResponse(HttpStatus.ACCEPTED.value(), "Accepted", "Operation succeed");
        } else {
            apiResponse = new ApiResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Error", "Invalid input");
        }
        return apiResponse;
    }

    @GetMapping(path = "findBy")
    public Order findByID(@RequestParam long id) {
        return inMemoryOrderService.findByID(id);
    }

    @PostMapping(path = "/deleteBy")
    public ApiResponse deleteByID(@RequestParam long id) {
        ApiResponse apiResponse;
        if (inMemoryOrderService.removeByID(id)) {
            apiResponse = new ApiResponse(HttpStatus.ACCEPTED.value(), "Accepted", "Operation succeed");
        } else {
            apiResponse = new ApiResponse(HttpStatus.NOT_ACCEPTABLE.value(), "Error", "Invalid input");
        }
        return apiResponse;
    }

    @GetMapping(path = "/inventory")
    public List<Order> getAll() {
        return inMemoryOrderService.getAll();
    }
}
