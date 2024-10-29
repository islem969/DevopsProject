package com.example.intershipmanagement.repositories;

import com.example.intershipmanagement.entities.Technologies;
import org.springframework.data.repository.CrudRepository;

public interface TechRepository extends CrudRepository<Technologies,Long> {
}
