package com.campuslands.inmobiliaria.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campuslands.inmobiliaria.repositories.entities.LocalEntity;

public interface RepositoryLocal extends CrudRepository<LocalEntity, Long>{
    
}
