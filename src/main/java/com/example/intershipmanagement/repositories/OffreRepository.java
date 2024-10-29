package com.example.intershipmanagement.repositories;

import com.example.intershipmanagement.entities.Demandes;
import com.example.intershipmanagement.entities.OffresStages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OffreRepository extends CrudRepository<OffresStages,Long> {
    List<OffresStages> findByEtat (String etat);



}
