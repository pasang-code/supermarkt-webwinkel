package be.thomasmore.grocerydeliverywebappspring.repositories;

import be.thomasmore.grocerydeliverywebappspring.controllers.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product,Integer> {

    public Product findTopByOrderByIdDesc();

    public Product findTopByOrderByIdAsc();

    @Query("SELECT p FROM Product p WHERE (:naam IS NULL OR p.productNaam ILIKE CONCAT('%',:naam,'%') ) AND (:gewicht IS NULL OR p.gewicht >= :gewicht) AND (:minPrijs IS NULL OR (p.prijs >= :minPrijs)) AND (:maxPrijs IS NULL OR p.prijs <= :maxPrijs) AND (:categorie IS NULL OR  LOWER(p.categorie)  = LOWER(:categorie)  ) AND(:isBiologisch IS NULL OR p.biologisch = :isBiologisch)")
    public List<Product> findByFilter(@Param("naam") String naam,@Param("gewicht") Double gewicht,@Param("minPrijs") Double minPrijs, @Param("maxPrijs") Double maxPrijs,@Param("categorie") String categorie, @Param("isBiologisch") Boolean isBiologisch);
}
