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





}
