package com.campuslands.inmobiliaria.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.inmobiliaria.dto.PisoOcasionDTO;
import com.campuslands.inmobiliaria.repositories.entities.PisoOcasionEntity;
import com.campuslands.inmobiliaria.repositories.entities.OficinaEntity;
import com.campuslands.inmobiliaria.repositories.entities.ZonaEntity;

@Component
public class PisoOcasionDTOConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public PisoOcasionDTO convertToDTO(PisoOcasionEntity pisoOcasionEntity){
        if (pisoOcasionEntity == null) {
            return null;
        }
    
        PisoOcasionDTO pisoOcasionDTO = modelMapper.map(pisoOcasionEntity, PisoOcasionDTO.class);
    
        if (pisoOcasionEntity.getOficina() != null) {
            pisoOcasionDTO.setId_oficina(pisoOcasionEntity.getOficina().getId());
        }
    
        if (pisoOcasionEntity.getZona() != null) {
            pisoOcasionDTO.setId_zona(pisoOcasionEntity.getZona().getId());
        }
    
        return pisoOcasionDTO;
    }

    public PisoOcasionEntity convertToEntity(PisoOcasionDTO pisoOcasionDTO) {
        if (pisoOcasionDTO == null) {
            return null;
        }
    
        PisoOcasionEntity pisoOcasionEntity = modelMapper.map(pisoOcasionDTO, PisoOcasionEntity.class);
    
        if (pisoOcasionDTO.getId_oficina() != null) {
            OficinaEntity oficinaEntity = new OficinaEntity();
            oficinaEntity.setId(pisoOcasionDTO.getId_oficina());
            pisoOcasionEntity.setOficina(oficinaEntity);
        } else {
            pisoOcasionEntity.setOficina(null);
        }
    
        if (pisoOcasionDTO.getId_zona() != null) {
            ZonaEntity zonaEntity = new ZonaEntity();
            zonaEntity.setId(pisoOcasionDTO.getId_zona());
            pisoOcasionEntity.setZona(zonaEntity);
        } else {
            pisoOcasionEntity.setZona(null); 
        }
    
        return pisoOcasionEntity;
    }
}
