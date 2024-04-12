package com.campuslands.inmobiliaria.repositories;

import org.springframework.data.repository.CrudRepository;

import com.campuslands.inmobiliaria.repositories.entities.ClienteEntity;

public interface RepositoryCliente extends CrudRepository<ClienteEntity, Long>{
    
}
