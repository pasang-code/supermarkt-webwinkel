package be.thomasmore.grocerydeliverywebappspring.repositories;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Category;
import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category,Integer> {

    Category findTopByOrderByIdAsc();

    Category findTopByOrderByIdDesc();

}
