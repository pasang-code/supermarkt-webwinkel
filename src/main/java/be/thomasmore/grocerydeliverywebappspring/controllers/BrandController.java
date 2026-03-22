package be.thomasmore.grocerydeliverywebappspring.controllers;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.Brand;
import be.thomasmore.grocerydeliverywebappspring.repositories.BrandRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class BrandController {

    private final BrandRepository brandRepository;

    public BrandController(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }

    @GetMapping("/brandDetails/{id}")
    public String brand(Model model, @PathVariable(required = false) Integer id) {
        Optional<Brand> brand = brandRepository.findById(id);

        if (brand.isPresent()) model.addAttribute("brand", brand.get());
        return "brandDetails";
    }

}