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
    public String shoppingCartAddPost(@RequestParam Integer productId, @RequestParam Integer quantity,@ModelAttribute("cart")
    ShoppingCart cart){

     Optional<Product> p = productRepository.findById(productId);
     CartItem cartItem = new CartItem();
     cartItem.setProduct(p.get());
     cartItem.setCart(cart);
     cartItem.setQuantity(quantity);
     cartItemRepository.save(cartItem);

    return "redirect:/productdetails/"+productId;
    }

    @PostMapping("/shoppingcartEdit/{id}")
    public String shoppingCartPost(Model model, @PathVariable(required = false) Integer id,ShoppingCart cart){
        shoppingCartRepository.save(cart);

        return "redirect:/home";
    }

    @PostMapping("/shoppingcartClear")
    public String shoppingCartClearPost(){
        cartItemRepository.deleteAll();
        return "redirect:/shoppingcart";
    }

    @PostMapping("/shoppingcartRemove")
    public String shoppingCartRemovePost(@RequestParam(required = false) Integer cartItemId){
        cartItemRepository.deleteById(cartItemId);
        return "redirect:/shoppingcart";
    }

    @PostMapping("/shoppingcartUpdate")
    public String shoppingCartUpdatePost(Model model, @RequestParam(required = false) String decrease,@RequestParam(required = false) String action,@RequestParam(required = false) Integer itemId){
        Optional<CartItem> item = cartItemRepository.findById(itemId);

        if (item.isPresent()){
            CartItem itemUpdate = item.get();
            if (action.equals("increase")) itemUpdate.setQuantity(itemUpdate.getQuantity()+1);
            if (action.equals("decrease")) itemUpdate.setQuantity(itemUpdate.getQuantity()-1);
            cartItemRepository.save(itemUpdate);
        }

        return "redirect:/shoppingcart";
    }

    @GetMapping("/shoppingcart")
    public String shoppingCart(Model model,@ModelAttribute("cart") ShoppingCart cart ){


        return "shoppingCart";
    }
}
