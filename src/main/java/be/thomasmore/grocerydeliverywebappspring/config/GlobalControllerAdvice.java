package be.thomasmore.grocerydeliverywebappspring.config;

import be.thomasmore.grocerydeliverywebappspring.controllers.ShoppingCartController;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.ShoppingCart;
import be.thomasmore.grocerydeliverywebappspring.repositories.ShoppingCartRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import javax.swing.text.html.Option;
import java.net.http.HttpRequest;
import java.time.LocalDateTime;
import java.util.Optional;

@ControllerAdvice
public class GlobalControllerAdvice {

    final ShoppingCartRepository shoppingCartRepository;

    public GlobalControllerAdvice(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @ModelAttribute("currentUrl")
    public String getCurrentUrl(HttpServletRequest request) {
        return request.getRequestURI();
    }

    @ModelAttribute("cart")
    public ShoppingCart cart() {
        Optional<ShoppingCart> cart = shoppingCartRepository.findById(1);
        if (cart.isPresent()) return cart.get();
        else {
            ShoppingCart cartNew = new ShoppingCart();
            cartNew.setCreatedAt(LocalDateTime.now());
            cartNew.setStatus("Active");
            ShoppingCart cartReturnedWithId = shoppingCartRepository.save(cartNew);
            return cartReturnedWithId;
        }

    }
}
