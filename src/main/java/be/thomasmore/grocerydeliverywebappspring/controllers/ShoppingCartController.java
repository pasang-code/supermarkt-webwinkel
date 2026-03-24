package be.thomasmore.grocerydeliverywebappspring.controllers;


import be.thomasmore.grocerydeliverywebappspring.controllers.model.CartItem;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.ShoppingCart;
import be.thomasmore.grocerydeliverywebappspring.repositories.CartItemRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@Controller
public class ShoppingCartController {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository, ProductRepository productRepository, CartItemRepository cartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }


    @PostMapping("/shoppingcartAdd")
    public String shoppingCartAddPost(@RequestParam Integer productId, @RequestParam Integer aantal,ShoppingCart cart){



    return "redirect:/productdetails/"+productId;
    }

    @PostMapping("/shoppingcartEdit/{id}")
    public String shoppingCartPost(Model model, @PathVariable(required = false) Integer id,ShoppingCart cart){
        shoppingCartRepository.save(cart);

        return "redirect:/home";
    }

    @GetMapping("/shoppingcart/{id}")
    public String shoppingCart(Model model, @PathVariable(required = false) Integer id){
        if (id==null) return "shoppingCart";

        return "shoppingCart";
    }
}
