package com.campuslands.inmobiliaria.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.campuslands.inmobiliaria.repositories.RepositoryCliente;
import com.campuslands.inmobiliaria.repositories.entities.ClienteEntity;
import com.campuslands.inmobiliaria.services.ClienteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements ClienteService {
    
    private final RepositoryCliente repositoryCliente;

    @Override
    public ClienteEntity saveCliente(ClienteEntity clienteEntity) {
        return repositoryCliente.save(clienteEntity);
    }

    @Override
    public ClienteEntity updateCliente(Long id, ClienteEntity clienteEntity) {
        Optional<ClienteEntity> clienteCurrentOptional = repositoryCliente.findById(id);

        if(clienteCurrentOptional.isPresent()){
            ClienteEntity clienteCurrent = clienteCurrentOptional.get();
            clienteCurrent.setNombre(clienteEntity.getNombre());
            clienteCurrent.setTelefono(clienteEntity.getTelefono());

            return clienteCurrent;
        }
        return null;
    }
    
}
