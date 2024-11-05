package com.example.intershipmanagement.Servise;

import com.example.intershipmanagement.entities.Demandes;
import com.example.intershipmanagement.repositories.DemandesRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Slf4j
@Service
public class DemandeServise implements IServiseDemande {

    private final DemandesRepository demandesRepository;
    private JavaMailSender javaMailSender;

    @Autowired
    public void EmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public Demandes ajouterdemandes(Demandes demandes) {
        demandes.setEtat("En Court");
        log.info("Ajout d'une nouvelle demande avec les informations : {}", demandes);
        return demandesRepository.save(demandes);
    }

    @Override
    public List<Demandes> getAlldemandes() {
        log.info("Récupération de toutes les demandes");
        return (List<Demandes>) demandesRepository.findAll();
    }

    @Override
    public Demandes getdemandesById(long id) {
        log.info("Récupération de la demande avec ID : {}", id);
        return demandesRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Demande avec ID {} non trouvée", id);
                    return new EntityNotFoundException("Demande non trouvée");
                });
    }

    @Override
    public void deletedemandes(long id) {
        log.info("Suppression de la demande avec ID : {}", id);
        demandesRepository.deleteById(id);
    }

    @Transactional
    public void acceptDemande(long id) {
        log.info("Acceptation de la demande avec ID : {}", id);
        Demandes demande = demandesRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Demande avec ID {} non trouvée pour acceptation", id);
                    return new EntityNotFoundException("Demande non trouvée");
                });
        demande.setEtat("ACCEPTER");
        demandesRepository.save(demande);
        log.info("Demande avec ID {} acceptée", id);
    }

    @Transactional
    public void refuserDemande(long id) {
        log.info("Refus de la demande avec ID : {}", id);
        Demandes demande = demandesRepository.findById(id)
                .orElseThrow(() -> {
                    log.error("Demande avec ID {} non trouvée pour refus", id);
                    return new EntityNotFoundException("Demande non trouvée");
                });
        demande.setEtat("REFUSER");
        demandesRepository.save(demande);
        log.info("Demande avec ID {} refusée", id);
    }

    @Override
    public void sendEmailNotification(Demandes demande) {
        log.info("Envoi d'un email de notification pour la demande : {}", demande);
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("dahmaninajwa20@gmail.com");
        message.setSubject("Demande de stage");
        message.setText("Form Data:\n" + demande.toString());
        javaMailSender.send(message);
    }

    @Override
    public List<Demandes> findByEtat(String etat) {
        log.info("Filtrage des demandes par état : {}", etat);
        return demandesRepository.findByEtat(etat);
    }

    @Override
    public Demandes updatedemandes(Demandes demandes) {
        log.info("Mise à jour de la demande avec ID : {}", demandes.getId());
        return demandesRepository.save(demandes);
    }
}
