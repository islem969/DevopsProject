package com.example.intershipmanagement.entities;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class OffresStages implements Serializable {
    @Id
    @GeneratedValue
    private Long idoff;
    String nomE;
    String logo;
    String url;
    String adresse;
    String descOffre;
    String Profile;
    String tecnoligie;
    Date datePost;
    Date datefin;
    int starRating;
    String etat;
    @OneToMany(cascade = CascadeType.ALL, mappedBy="offresstages")
    private Set<Demandes> Demandess ;
    @ManyToMany
    @JoinTable(
            name = "offres_technologies",
            joinColumns = @JoinColumn(name = "offre_id"),
            inverseJoinColumns = @JoinColumn(name = "technology_id")
    )
    private Set<Technologies> technologiess = new HashSet<>();

    public Set<Technologies> getTechnologies() {
        return technologiess;
    }

    public void setIdoff(Long idoff) {
        this.idoff = idoff;
    }

    public void setTechnologies(Set<Technologies> technologies) {
        this.technologiess = technologies;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setDescOffre(String descOffre) {
        this.descOffre = descOffre;
    }

    public void setProfile(String profile) {
        Profile = profile;
    }

    public void setTecnoligie(String tecnoligie) {
        this.tecnoligie = tecnoligie;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public void setDemandess(Set<Demandes> demandess) {
        Demandess = demandess;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    public String getNomE() {
        return nomE;
    }

    public String getLogo() {
        return logo;
    }

    public String getUrl() {
        return url;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getDescOffre() {
        return descOffre;
    }

    public String getProfile() {
        return Profile;
    }

    public String getTecnoligie() {
        return tecnoligie;
    }

    public Date getDatePost() {
        return datePost;
    }

    public Date getDatefin() {
        return datefin;
    }

    public Set<Demandes> getDemandess() {
        return Demandess;
    }

    public Long getIdoff() {
        return idoff;
    }

    public void setStarRating(int starRating) {
        this.starRating = starRating;
    }

    public int getStarRating() {
        return starRating;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getEtat() {
        return etat;
    }



}
