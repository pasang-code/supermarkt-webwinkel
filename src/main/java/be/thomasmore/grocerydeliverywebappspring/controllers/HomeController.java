package be.thomasmore.grocerydeliverywebappspring.controllers;


import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Iterator;
import java.util.Optional;

@Controller
public class HomeController {
 private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping({"/home","/"})
    public String home(Model model){
        Iterable<Product> listProduct = productRepository.findAll();
        model.addAttribute("Productlist",listProduct);
        return "home";
    }
}
