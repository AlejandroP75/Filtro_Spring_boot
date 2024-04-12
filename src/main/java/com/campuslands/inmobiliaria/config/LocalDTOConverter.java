package com.campuslands.inmobiliaria.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.inmobiliaria.dto.LocalDTO;
import com.campuslands.inmobiliaria.repositories.entities.LocalEntity;
import com.campuslands.inmobiliaria.repositories.entities.OficinaEntity;
import com.campuslands.inmobiliaria.repositories.entities.ZonaEntity;

@Component
public class LocalDTOConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public LocalDTO convertToDTO(LocalEntity localEntity){
        if (localEntity == null) {
            return null;
        }
    
        LocalDTO localDTO = modelMapper.map(localEntity, LocalDTO.class);
    
        if (localEntity.getOficina() != null) {
            localDTO.setId_oficina(localEntity.getOficina().getId());
        }
    
        if (localEntity.getZona() != null) {
            localDTO.setId_zona(localEntity.getZona().getId());
        }
    
        return localDTO;
    }

    public LocalEntity convertToEntity(LocalDTO localDTO) {
        if (localDTO == null) {
            return null;
        }
    
        LocalEntity localEntity = modelMapper.map(localDTO, LocalEntity.class);
    
        if (localDTO.getId_oficina() != null) {
            OficinaEntity oficinaEntity = new OficinaEntity();
            oficinaEntity.setId(localDTO.getId_oficina());
            localEntity.setOficina(oficinaEntity);
        } else {
            localEntity.setOficina(null);
        }
    
        if (localDTO.getId_zona() != null) {
            ZonaEntity zonaEntity = new ZonaEntity();
            zonaEntity.setId(localDTO.getId_zona());
            localEntity.setZona(zonaEntity);
        } else {
            localEntity.setZona(null); 
        }
    
        return localEntity;
    }
}
