package com.example.intershipmanagement.entities;

import com.example.intershipmanagement.entities.enumerations.Etatdemande;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Demandes implements Serializable {
    @Id
    @GeneratedValue
    private Long id;
    String nomET;
    String PresnomET;
    String mail;
    String CV;
    String lettreMot;
    String classe;
    String telNumber;
    String demndeStage;
    String etat;
    @ManyToOne
    OffresStages offresstages;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomET() {
        return nomET;
    }

    public void setNomET(String nomET) {
        this.nomET = nomET;
    }

    public String getPresnomET() {
        return PresnomET;
    }

    public void setPresnomET(String presnomET) {
        PresnomET = presnomET;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public String getLettreMot() {
        return lettreMot;
    }

    public void setLettreMot(String lettreMot) {
        this.lettreMot = lettreMot;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getDemndeStage() {
        return demndeStage;
    }

    public void setDemndeStage(String demndeStage) {
        this.demndeStage = demndeStage;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public OffresStages getOffresstages() {
        return offresstages;
    }

    public void setOffresstages(OffresStages offresstages) {
        this.offresstages = offresstages;
    }
}
