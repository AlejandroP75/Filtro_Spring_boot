package com.campuslands.inmobiliaria.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.inmobiliaria.dto.PisoNuevoDTO;
import com.campuslands.inmobiliaria.repositories.entities.PisoNuevoEntity;
import com.campuslands.inmobiliaria.repositories.entities.OficinaEntity;
import com.campuslands.inmobiliaria.repositories.entities.ZonaEntity;

@Component
public class PisoNuevoDTOConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public PisoNuevoDTO convertToDTO(PisoNuevoEntity pisoNuevoEntity){
        if (pisoNuevoEntity == null) {
            return null;
        }
    
        PisoNuevoDTO pisoNuevoDTO = modelMapper.map(pisoNuevoEntity, PisoNuevoDTO.class);
    
        if (pisoNuevoEntity.getOficina() != null) {
            pisoNuevoDTO.setId_oficina(pisoNuevoEntity.getOficina().getId());
        }
    
        if (pisoNuevoEntity.getZona() != null) {
            pisoNuevoDTO.setId_zona(pisoNuevoEntity.getZona().getId());
        }
    
        return pisoNuevoDTO;
    }

    public PisoNuevoEntity convertToEntity(PisoNuevoDTO pisoNuevoDTO) {
        if (pisoNuevoDTO == null) {
            return null;
        }
    
        PisoNuevoEntity pisoNuevoEntity = modelMapper.map(pisoNuevoDTO, PisoNuevoEntity.class);
    
        if (pisoNuevoDTO.getId_oficina() != null) {
            OficinaEntity oficinaEntity = new OficinaEntity();
            oficinaEntity.setId(pisoNuevoDTO.getId_oficina());
            pisoNuevoEntity.setOficina(oficinaEntity);
        } else {
            pisoNuevoEntity.setOficina(null);
        }
    
        if (pisoNuevoDTO.getId_zona() != null) {
            ZonaEntity zonaEntity = new ZonaEntity();
            zonaEntity.setId(pisoNuevoDTO.getId_zona());
            pisoNuevoEntity.setZona(zonaEntity);
        } else {
            pisoNuevoEntity.setZona(null); 
        }
    
        return pisoNuevoEntity;
    }
}
