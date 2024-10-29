package com.example.intershipmanagement.Servise;

import com.example.intershipmanagement.entities.Demandes;
import com.example.intershipmanagement.entities.OffresStages;
import com.example.intershipmanagement.entities.Technologies;
import com.example.intershipmanagement.repositories.OffreRepository;
import com.example.intershipmanagement.repositories.TechRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Slf4j
@Service
public class ServiseTech implements ITechS{
    TechRepository techRepository;
    @Override
    public Technologies ajouterITechS(Technologies tech) {
            return  techRepository.save(tech);}

    @Override
    public Technologies updateITechS(Technologies tech) {
        Long id = tech.getId();
        if (techRepository.existsById(id)) {
            return techRepository.save(tech);
        } else {

            return null;
        }
    }

    @Override
    public Technologies getITechSById(long id) {
        return techRepository.findById(id).orElse(null);
    }

    @Override
    public List<Technologies> getAllITechS() {
        return (List<Technologies>) techRepository.findAll();
    }


    @Override
    public void deleteITechS(long id) {
        techRepository.deleteById(id);

    }
}
