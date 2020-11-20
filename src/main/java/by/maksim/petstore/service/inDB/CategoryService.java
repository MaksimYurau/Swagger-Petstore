package by.maksim.petstore.service.inDB;

import by.maksim.petstore.entity.Category;
import by.maksim.petstore.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public boolean save(@Valid Category category) {
        if (categoryRepository.existsByName(category.getName())) {
            return false;
        }
        categoryRepository.save(category);
        return true;
    }

    public Category getById(int id) {
        return categoryRepository.getOne((long) id);
    }

    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    public void delete(int id) {
        categoryRepository.deleteById((long) id);
    }

    public boolean update(@Valid Category category) {
        if (categoryRepository.existsById((long) category.getId())) {
            categoryRepository.save(category);
            return true;
        }
        return false;
    }
}
