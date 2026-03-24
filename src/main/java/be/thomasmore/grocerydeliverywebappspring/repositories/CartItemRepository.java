package be.thomasmore.grocerydeliverywebappspring.repositories;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.CartItem;
import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem,Integer> {
}
