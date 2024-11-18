package fit.se.iuh.service;


import org.springframework.stereotype.Service;

import fit.se.iuh.model.Category;

import java.util.List;
import java.util.Optional;

@Service
public interface CategoryService {

    public List<Category> getAllCategory();

    public void updateCategory(Category category);

    public void removeCategoryById(int id);

    public Optional<Category> getCategoryById(int id);

}
