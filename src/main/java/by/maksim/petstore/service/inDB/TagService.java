package by.maksim.petstore.service.inDB;

import by.maksim.petstore.entity.Tag;
import by.maksim.petstore.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService {

    @Autowired
    private TagRepository tagRepository;

    public boolean save(Tag tag) {
        if (tagRepository.existsByName(tag.getName())) {
            return false;
        }
        tagRepository.save(tag);
        return true;
    }

    public Tag getById(int id) {
        return tagRepository.getOne((long) id);
    }

    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    public void deleteById(int id) {
        tagRepository.deleteById((long) id);
    }

    public boolean update(Tag tag) {
        if (tagRepository.existsById((long) tag.getId())) {
            tagRepository.save(tag);
            return true;
        }
        return false;
    }
}
