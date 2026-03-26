package be.thomasmore.grocerydeliverywebappspring.controllers.admin;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Brand;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.Category;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.repositories.BrandRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.CategoryRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("/admin")
@Controller
public class AdminController {

    private final ProductRepository productRepository;
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;

    public AdminController(ProductRepository productRepository,
                           BrandRepository brandRepository,
                           CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.brandRepository = brandRepository;
        this.categoryRepository = categoryRepository;
    }

    @ModelAttribute("product")
    public Product editProduct(@PathVariable(required = false) Integer id) {
        if (id == null) return null;
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) return product.get();
        return null;
    }

    @GetMapping("/product-details-edit/{id}")
    public String editProductDetails(Model model,
                                     @PathVariable Integer id,
                                     @ModelAttribute("product") Product product) {
        Iterable<Brand> brands = brandRepository.findAll();
        Iterable<Category> categories = categoryRepository.findAll();

        model.addAttribute("brands", brands);
        model.addAttribute("categories", categories);
        return "product-details-edit";
    }

    @PostMapping("/product-details-edit/{id}")
    public String editProductDetailsPost(Model model,
                                         @ModelAttribute("product") @Valid Product product,
                                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Iterable<Brand> brands = brandRepository.findAll();
            Iterable<Category> categories = categoryRepository.findAll();

            model.addAttribute("brands", brands);
            model.addAttribute("categories", categories);
            return "product-details-edit";
        }

        Product savedProduct = productRepository.save(product);
        return "redirect:/product-details/" + savedProduct.getId();
    }
}