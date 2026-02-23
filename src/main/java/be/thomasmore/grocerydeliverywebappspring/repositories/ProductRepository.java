package be.thomasmore.grocerydeliverywebappspring.repositories;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product,Integer> {

}
