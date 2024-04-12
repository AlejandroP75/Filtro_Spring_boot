package com.campuslands.inmobiliaria.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.inmobiliaria.dto.CasaDTO;
import com.campuslands.inmobiliaria.repositories.entities.CasaEntity;
import com.campuslands.inmobiliaria.repositories.entities.OficinaEntity;
import com.campuslands.inmobiliaria.repositories.entities.ZonaEntity;

@Component
public class CasaDTOConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public CasaDTO convertToDTO(CasaEntity casaEntity){
        if (casaEntity == null) {
            return null;
        }
    
        CasaDTO casaDTO = modelMapper.map(casaEntity, CasaDTO.class);
    
        if (casaEntity.getOficina() != null) {
            casaDTO.setId_oficina(casaEntity.getOficina().getId());
        }
    
        if (casaEntity.getZona() != null) {
            casaDTO.setId_zona(casaEntity.getZona().getId());
        }
    
        return casaDTO;
    }

    public CasaEntity convertToEntity(CasaDTO casaDTO) {
        if (casaDTO == null) {
            return null;
        }
    
        CasaEntity casaEntity = modelMapper.map(casaDTO, CasaEntity.class);
    
        if (casaDTO.getId_oficina() != null) {
            OficinaEntity oficinaEntity = new OficinaEntity();
            oficinaEntity.setId(casaDTO.getId_oficina());
            casaEntity.setOficina(oficinaEntity);
        } else {
            casaEntity.setOficina(null);
        }
    
        if (casaDTO.getId_zona() != null) {
            ZonaEntity zonaEntity = new ZonaEntity();
            zonaEntity.setId(casaDTO.getId_zona());
            casaEntity.setZona(zonaEntity);
        } else {
            casaEntity.setZona(null); 
        }
    
        return casaEntity;
    }
}
