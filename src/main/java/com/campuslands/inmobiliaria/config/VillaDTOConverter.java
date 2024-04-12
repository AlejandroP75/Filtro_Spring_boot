package com.campuslands.inmobiliaria.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.campuslands.inmobiliaria.dto.VillaDTO;
import com.campuslands.inmobiliaria.repositories.entities.VillaEntity;
import com.campuslands.inmobiliaria.repositories.entities.OficinaEntity;

@Component
public class VillaDTOConverter {
    
    @Autowired
    private ModelMapper modelMapper;

    public VillaDTO convertToDTO(VillaEntity villaEntity){
        if (villaEntity == null) {
            return null;
        }
    
        VillaDTO villaDTO = modelMapper.map(villaEntity, VillaDTO.class);
    
        if (villaEntity.getOficina() != null) {
            villaDTO.setId_oficina(villaEntity.getOficina().getId());
        }
    
        return villaDTO;
    }

    public VillaEntity convertToEntity(VillaDTO villaDTO) {
        if (villaDTO == null) {
            return null;
        }
    
        VillaEntity villaEntity = modelMapper.map(villaDTO, VillaEntity.class);
    
        if (villaDTO.getId_oficina() != null) {
            OficinaEntity oficinaEntity = new OficinaEntity();
            oficinaEntity.setId(villaDTO.getId_oficina());
            villaEntity.setOficina(oficinaEntity);
        } else {
            villaEntity.setOficina(null);
        }

    
        return villaEntity;
    }
}
