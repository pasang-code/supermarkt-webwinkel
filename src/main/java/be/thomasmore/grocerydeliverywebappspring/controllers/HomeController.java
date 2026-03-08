package be.thomasmore.grocerydeliverywebappspring.controllers;


import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Iterator;
import java.util.Optional;

@Controller
public class HomeController {
 private final ProductRepository productRepository;

    public HomeController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping({"/home","/"})
    public String home(Model model,@RequestParam(required = false) String naam, @RequestParam(required = false)Double gewicht,@RequestParam(required = false) Double minPrijs,@RequestParam(required = false) Double maxPrijs,@RequestParam(required = false) String categorie,@RequestParam(required = false) Boolean isBiologisch,@RequestParam(required = false) String searchQuery){
        Iterable<Product> listProduct = productRepository.findByFilter(naam,gewicht,minPrijs,maxPrijs,categorie,isBiologisch,searchQuery);
        model.addAttribute("productlist",listProduct);
        return "home";
    }
}
