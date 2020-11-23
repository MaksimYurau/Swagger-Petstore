package by.maksim.petstore.controller;

import by.maksim.petstore.entity.Tag;
import by.maksim.petstore.service.inDB.TagService;
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

    @Autowired
    private TagService tagService;

    @PostMapping
    public ResponseEntity<Boolean> save(@Valid @RequestBody Tag tag) {
        if (tagService.save(tag)) {
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping(path = "/getById")
    public ResponseEntity<Tag> getById(@RequestParam int id) {
        return new ResponseEntity<>(tagService.getById(id), HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/getAll")
    public ResponseEntity<List<Tag>> getAll() {
        return new ResponseEntity<>(tagService.getAll(), HttpStatus.ACCEPTED);
    }

    @DeleteMapping
    public ResponseEntity deleteById(@RequestParam int id) {
        tagService.deleteById(id);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
