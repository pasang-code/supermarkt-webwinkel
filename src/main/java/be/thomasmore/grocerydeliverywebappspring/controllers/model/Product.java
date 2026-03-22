package be.thomasmore.grocerydeliverywebappspring.controllers.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productName;
    private String description;
    private Double price;
    private Double weight;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Category> categories;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Promotion> promotions;
    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;
    private Boolean organic;

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Promotion> getPromotions() {
        return promotions;
    }

    public void setPromotions(Collection<Promotion> promotions) {
        this.promotions = promotions;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Boolean getOrganic() {
        return organic;
    }

    public void setOrganic(Boolean organic) {
        this.organic = organic;
    }

    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}