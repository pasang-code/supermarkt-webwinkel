package be.thomasmore.grocerydeliverywebappspring.controllers;


import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class ProductController {
    private final ProductRepository productRepository;
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/productdetails{id}")
    public String venueDetails(Model model,@PathVariable Integer id)
    {
        Integer largestId = productRepository.findTopByOrderByIdDesc().getId();
        Integer lowestId = productRepository.findTopByOrderByIdAsc().getId();

        if (id>largestId){
            id = lowestId;
            return "redirect:/productdetails"+id;

        }

        if (id<lowestId){
            id = largestId;
            return "redirect:/productdetails"+id;
        }

        Optional<Product> p1 = productRepository.findById(id);
        if (p1.isPresent()){
            model.addAttribute("product",p1.get());
        }


        return "productDetails";

    }
}
