package be.thomasmore.grocerydeliverywebappspring.controllers.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productNaam;
    private String beschrijving;
    private Double prijs;
    private Double gewicht;

    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Category> categories;
    private String categorie;
    @ManyToMany(fetch = FetchType.LAZY)
    private Collection<Promotie> promoties;
    @ManyToOne(fetch = FetchType.LAZY)
    private Merk merk;
    private Boolean biologisch;

    public Collection<Category> getCategories() {
        return categories;
    }

    public void setCategories(Collection<Category> categories) {
        this.categories = categories;
    }

    public Collection<Promotie> getPromoties() {
        return promoties;
    }

    public void setPromoties(Collection<Promotie> promoties) {
        this.promoties = promoties;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Merk getMerk() {
        return merk;
    }

    public void setMerk(Merk merk) {
        this.merk = merk;
    }

    public Boolean getBiologisch() {
        return biologisch;
    }

    public void setBiologisch(Boolean biologisch) {
        this.biologisch = biologisch;
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

    public String getProductNaam() {
        return productNaam;
    }

    public void setProductNaam(String productNaam) {
        this.productNaam = productNaam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Double getPrijs() {
        return prijs;
    }

    public void setPrijs(Double prijs) {
        this.prijs = prijs;
    }
}
