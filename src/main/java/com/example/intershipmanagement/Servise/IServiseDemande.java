package com.example.intershipmanagement.Servise;

import com.example.intershipmanagement.entities.Demandes;
import com.example.intershipmanagement.entities.OffresStages;
import com.example.intershipmanagement.entities.enumerations.Etatdemande;
import org.springframework.mail.javamail.JavaMailSender;

import java.util.List;

public interface IServiseDemande {

    public Demandes ajouterdemandes (Demandes demandes);
    public Demandes updatedemandes (Demandes demandes);
    public Demandes getdemandesById(long id);
    public List<Demandes> getAlldemandes();
    public void deletedemandes(long id);
    //public List<Demandes>getDemandesByidoff(Long idoff);
    public void refuserDemande(long id);
    public void acceptDemande(long id);
    public List<Demandes> findByEtat(String etat);
    public void sendEmailNotification(Demandes demande);
    public void EmailService(JavaMailSender javaMailSender);

}
