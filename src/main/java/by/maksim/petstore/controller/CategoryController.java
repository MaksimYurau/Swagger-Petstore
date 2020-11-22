package by.maksim.petstore.controller;

import by.maksim.petstore.entity.Category;
import by.maksim.petstore.service.inDB.CategoryService;
import by.maksim.petstore.service.inMemory.InMemoryCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/category")
public class CategoryController {

    @Autowired
    private InMemoryCategoryService inMemoryCategoryService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<Boolean> save(@Valid @RequestBody Category category) {
        if (inMemoryCategoryService.save(category)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getById")
    public ResponseEntity<Category> getById(@RequestParam int id) {
        return new ResponseEntity<>(inMemoryCategoryService.getById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<>(inMemoryCategoryService.getAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity deleteById(@RequestParam int id) {
        inMemoryCategoryService.delete(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
