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
    import org.springframework.web.bind.annotation.*;

    import java.util.Optional;

    @RequestMapping("/admin")
    @Controller
    public class AdminController {
         private final ProductRepository productRepository;
         private final BrandRepository brandRepository;
         private final CategoryRepository categoryRepository;

        public AdminController(ProductRepository productRepository, BrandRepository brandRepository, CategoryRepository categoryRepository) {
            this.productRepository = productRepository;
            this.brandRepository = brandRepository;
            this.categoryRepository = categoryRepository;
        }

        @ModelAttribute("product")
        public Product editProduct(@PathVariable(required = false) Integer id){
            if (id == null) return null;
            Optional<Product> product = productRepository.findById(id);
            if (product.isPresent()) return product.get();

            return null;
        }

        @PostMapping("/productdetailsEdit/{id}")
        public String editProductDetailsPost(Model model,@ModelAttribute("product") @Valid Product product, BindingResult bindingResult){
            if (bindingResult.hasErrors())
            {
                Iterable<Brand> brands = brandRepository.findAll();
                Iterable<Category> categories = categoryRepository.findAll();

                model.addAttribute("brands",brands);
                model.addAttribute("categories",categories);
                return "productDetailsEdit";
            }
           Product returnedProduct = productRepository.save(product);

           return "redirect:/productdetails/"+returnedProduct.getId();
        }

        @GetMapping("/productdetailsEdit/{id}")
        public String editProductDetails(Model model, @PathVariable(required = false) Integer id,@ModelAttribute("product") Product product){
            Iterable<Brand> brands = brandRepository.findAll();
            Iterable<Category> categories = categoryRepository.findAll();

            model.addAttribute("brands",brands);
            model.addAttribute("categories",categories);
            return "productDetailsEdit";
        }

    }
