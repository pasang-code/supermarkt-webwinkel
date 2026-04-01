package be.thomasmore.grocerydeliverywebappspring.controllers;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Category;
import be.thomasmore.grocerydeliverywebappspring.repositories.CategoryRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class CategoryController {

    private final CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @GetMapping({"/category-details/{id}","/category-details"})
    public String categoryDetails(Model model, @PathVariable(required = false) Integer id) {

        if (id==null) return "category-details";
        Integer highest = categoryRepository.findTopByOrderByIdDesc().getId();
        Integer lowest = categoryRepository.findTopByOrderByIdAsc().getId();

        if (id>highest) id = lowest;
        if (id<lowest) id = highest;

        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) {
            model.addAttribute("category", category.get());
        }

        return "category-details";
    }
}