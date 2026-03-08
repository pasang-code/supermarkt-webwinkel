package be.thomasmore.grocerydeliverywebappspring.repositories;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Merk;
import org.springframework.data.repository.CrudRepository;

public interface MerkRepository extends CrudRepository<Merk,Integer> {
}
