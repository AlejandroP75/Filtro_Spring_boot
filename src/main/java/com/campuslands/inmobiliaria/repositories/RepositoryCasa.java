package com.campuslands.inmobiliaria.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campuslands.inmobiliaria.repositories.entities.CasaEntity;

public interface RepositoryCasa extends CrudRepository<CasaEntity, Long>{
    
}
