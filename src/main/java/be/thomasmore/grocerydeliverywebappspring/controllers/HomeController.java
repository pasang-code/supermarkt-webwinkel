package be.thomasmore.grocerydeliverywebappspring.controllers;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping({"/home", "/"})
    public String home(Model model,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) Double weight,
                       @RequestParam(required = false) Double minPrice,
                       @RequestParam(required = false) Double maxPrice,
                       @RequestParam(required = false) String category,
                       @RequestParam(required = false) Boolean isOrganic,
                       @RequestParam(required = false) String searchQuery) {

        Iterable<Product> listProduct = productRepository.findByFilter(name, weight, minPrice, maxPrice, category, isOrganic, searchQuery);
        model.addAttribute("productlist", listProduct);
        return "home";
    }
}