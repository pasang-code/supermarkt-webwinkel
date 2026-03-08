package be.thomasmore.grocerydeliverywebappspring.controllers.model;

import jakarta.persistence.*;
import java.util.Collection;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;                // e.g., "Deals", "Nieuwkomers"
    private String description;         // Optional: short explanation
    private String imageUrl;            // Optional: banner image or icon
    private Boolean featured;           // Is this category highlighted on homepage?
    private Integer displayOrder;       // Optional: ordering of categories in UI
    @ManyToMany(mappedBy = "categories",fetch = FetchType.LAZY)
    private Collection<Product> products;

    // Getters and setters
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public Boolean getFeatured() { return featured; }
    public void setFeatured(Boolean featured) { this.featured = featured; }

    public Integer getDisplayOrder() { return displayOrder; }
    public void setDisplayOrder(Integer displayOrder) { this.displayOrder = displayOrder; }

    public Collection<Product> getProducts() { return products; }
    public void setProducts(Collection<Product> products) { this.products = products; }


}