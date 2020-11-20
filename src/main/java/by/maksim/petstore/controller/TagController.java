package by.maksim.petstore.controller;

import by.maksim.petstore.entity.Tag;
import by.maksim.petstore.service.inMemory.InMemoryTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/tag")
public class TagController {

    @Autowired
    private InMemoryTagService inMemoryTagService;

    @PostMapping
    public ResponseEntity<Boolean> save(@Valid @RequestBody Tag tag) {
        if (inMemoryTagService.save(tag)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getById")
    public ResponseEntity<Tag> getById(@RequestParam int id) {
        return new ResponseEntity<>(inMemoryTagService.getById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Tag>> getAll() {
        return new ResponseEntity<>(inMemoryTagService.getAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity deleteById(@RequestParam int id) {
        inMemoryTagService.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
