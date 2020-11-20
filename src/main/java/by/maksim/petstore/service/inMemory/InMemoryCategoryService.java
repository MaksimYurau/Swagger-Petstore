package by.maksim.petstore.service.inMemory;

import by.maksim.petstore.entity.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InMemoryCategoryService {
    private List<Category> categories = new ArrayList<>();

    public boolean save(Category category) {
        return categories.add(category);
    }

    public Category getById(int id) {
        Category category = null;
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                return categories.get(i);
            }
        }
        return category;
    }

    public List<Category> getAll() {
        return categories;
    }

    public boolean delete(int id) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == id) {
                categories.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean update (Category category) {
        for (int i = 0; i < categories.size(); i++) {
            if (categories.get(i).getId() == category.getId()) {
                categories.set(i, category);
                return true;
            }
        }
        return false;
    }
}
