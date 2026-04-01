package be.thomasmore.grocerydeliverywebappspring.controllers;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.CartItem;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.ShoppingCart;
import be.thomasmore.grocerydeliverywebappspring.repositories.CartItemRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ProductRepository;
import be.thomasmore.grocerydeliverywebappspring.repositories.ShoppingCartRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class ShoppingCartController {

    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;
    private final CartItemRepository cartItemRepository;

    public ShoppingCartController(ShoppingCartRepository shoppingCartRepository,
                                  ProductRepository productRepository,
                                  CartItemRepository cartItemRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @PostMapping("/shopping-cart-add")
    public String shoppingCartAddPost(@RequestParam Integer productId,
                                      @RequestParam(required = false) Integer quantity,
                                      @ModelAttribute("cart") ShoppingCart cart,
                                      Model model) {
        Optional<Product> product = productRepository.findById(productId);

        if (quantity == null || quantity <= 0) {   /* server side validation of input quantity*/
            model.addAttribute("invalidInput", true);
            if (product.isPresent()) {
                model.addAttribute("product", product.get());
            }
            return "product-details";
        }

        if(product.isPresent()) {
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product.get());
            cartItem.setCart(cart);
            cartItem.setQuantity(quantity);
            cartItemRepository.save(cartItem);
        }
        return "redirect:/product-details/" + productId;

    }

    @PostMapping("/shopping-cart-clear")
    public String shoppingCartClearPost() {
        cartItemRepository.deleteAll();
        return "redirect:/shopping-cart";
    }
    @PostMapping("/shopping-cart-remove")
    public String shoppingCartRemovePost(@RequestParam Integer cartItemId) {
        Optional<CartItem> cartItem = cartItemRepository.findById(cartItemId);

        if (cartItem.isPresent()) {
            CartItem itemToRemove = cartItem.get();
            cartItemRepository.deleteById(itemToRemove.getId());
        }

        return "redirect:/shopping-cart";
    }

    @PostMapping("/shopping-cart-update")
    public String shoppingCartUpdatePost(@RequestParam String action,
                                         @RequestParam Integer itemId) {
        Optional<CartItem> cartItem = cartItemRepository.findById(itemId);

        if (cartItem.isPresent()) {
            CartItem itemToUpdate = cartItem.get();
            if (action.equals("increase")) itemToUpdate.setQuantity(itemToUpdate.getQuantity() + 1);
            if (action.equals("decrease")) itemToUpdate.setQuantity(itemToUpdate.getQuantity() - 1);
            cartItemRepository.save(itemToUpdate);
        }

        return "redirect:/shopping-cart";
    }

    @GetMapping("/shopping-cart")
    public String shoppingCart(@ModelAttribute("cart") ShoppingCart cart) {
        return "shopping-cart";
    }
}