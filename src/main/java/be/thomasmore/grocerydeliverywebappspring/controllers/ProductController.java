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

    @GetMapping("/product-details/{id}")
    public String productDetails(Model model, @PathVariable Integer id) {
        Integer highest = productRepository.findTopByOrderByIdDesc().getId();
        Integer lowest = productRepository.findTopByOrderByIdAsc().getId();

        if (id>highest) id = lowest;
        if (id<lowest) id = highest;

        Optional<Product> product = productRepository.findById(id);

        if (product.isPresent()) {
            model.addAttribute("product", product.get());
        }

        return "product-details";
    }
}