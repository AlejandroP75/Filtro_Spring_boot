package com.campuslands.inmobiliaria.services;

import com.campuslands.inmobiliaria.repositories.entities.ClienteEntity;

public interface ClienteService {
    
    ClienteEntity saveCliente(ClienteEntity clienteEntity);

    ClienteEntity updateCliente(Long id, ClienteEntity clienteEntity);
}
