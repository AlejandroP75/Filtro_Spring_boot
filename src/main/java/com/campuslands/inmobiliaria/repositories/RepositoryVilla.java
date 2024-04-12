package com.campuslands.inmobiliaria.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campuslands.inmobiliaria.repositories.entities.VillaEntity;

public interface RepositoryVilla extends CrudRepository<VillaEntity, Long>{
    
}
