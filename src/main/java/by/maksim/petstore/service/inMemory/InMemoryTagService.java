package by.maksim.petstore.service.inMemory;

import by.maksim.petstore.entity.Tag;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryTagService {
    List<Tag> tags = new ArrayList<>();

    public boolean save(Tag tag) {
        return tags.add(tag);
    }

    public Tag getById(int id) {
        Tag tag = null;
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getId() == id) {
                tags.remove(i);
                return tags.get(i);
            }
        }
        return tag;
    }

    public List<Tag> getAll() {
        return tags;
    }

    public boolean deleteById(int id) {
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getId() == id) {
                tags.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean update (Tag tag) {
        for (int i = 0; i < tags.size(); i++) {
            if (tags.get(i).getId() == tag.getId()) {
                tags.set(i, tag);
                return true;
            }
        }
        return false;
    }
}
