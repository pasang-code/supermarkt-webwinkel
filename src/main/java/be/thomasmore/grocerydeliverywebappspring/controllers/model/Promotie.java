package be.thomasmore.grocerydeliverywebappspring.controllers.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Promotie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String naam;
    private String beschrijving;
    private Double kortingPercentage;

    private LocalDate startDatum;
    private LocalDate eindDatum;

    private Boolean actief;

    private String bannerImageUrl;

    @ManyToMany(mappedBy = "promoties", fetch = FetchType.LAZY)
    private Collection<Product> products;

    // getters & setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public Double getKortingPercentage() {
        return kortingPercentage;
    }

    public void setKortingPercentage(Double kortingPercentage) {
        this.kortingPercentage = kortingPercentage;
    }

    public LocalDate getStartDatum() {
        return startDatum;
    }

    public void setStartDatum(LocalDate startDatum) {
        this.startDatum = startDatum;
    }

    public LocalDate getEindDatum() {
        return eindDatum;
    }

    public void setEindDatum(LocalDate eindDatum) {
        this.eindDatum = eindDatum;
    }

    public Boolean getActief() {
        return actief;
    }

    public void setActief(Boolean actief) {
        this.actief = actief;
    }

    public String getBannerImageUrl() {
        return bannerImageUrl;
    }

    public void setBannerImageUrl(String bannerImageUrl) {
        this.bannerImageUrl = bannerImageUrl;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}