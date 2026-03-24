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

    @GetMapping("/categoryDetails/{id}")
    public String category(Model model,@PathVariable(required = false) Integer id){
        if (id==null) return "categoryDetails";

        Integer highestId = categoryRepository.findTopByOrderByIdDesc().getId();
        Integer lowestId = categoryRepository.findTopByOrderByIdAsc().getId();

        if (id>highestId) id = lowestId;
        if (id<lowestId) id = highestId;

        Optional<Category> category = categoryRepository.findById(id);

        if (category.isPresent()) model.addAttribute("category",category.get());

        return "categoryDetails";
    }
}
