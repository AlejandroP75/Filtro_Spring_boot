package com.campuslands.inmobiliaria.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campuslands.inmobiliaria.config.CasaDTOConverter;
import com.campuslands.inmobiliaria.config.LocalDTOConverter;
import com.campuslands.inmobiliaria.config.PisoNuevoDTOConverter;
import com.campuslands.inmobiliaria.config.PisoOcasionDTOConverter;
import com.campuslands.inmobiliaria.config.VillaDTOConverter;
import com.campuslands.inmobiliaria.dto.CasaDTO;
import com.campuslands.inmobiliaria.dto.LocalDTO;
import com.campuslands.inmobiliaria.dto.PisoNuevoDTO;
import com.campuslands.inmobiliaria.dto.PisoOcasionDTO;
import com.campuslands.inmobiliaria.dto.VillaDTO;
import com.campuslands.inmobiliaria.repositories.RepositoryCasa;
import com.campuslands.inmobiliaria.repositories.RepositoryLocal;
import com.campuslands.inmobiliaria.repositories.RepositoryPisoNuevo;
import com.campuslands.inmobiliaria.repositories.RepositoryPisoOcasion;
import com.campuslands.inmobiliaria.repositories.RepositoryVilla;
import com.campuslands.inmobiliaria.repositories.RepositoryVisitaCasa;
import com.campuslands.inmobiliaria.repositories.RepositoryVisitaLocal;
import com.campuslands.inmobiliaria.repositories.RepositoryVisitaPisoNuevo;
import com.campuslands.inmobiliaria.repositories.RepositoryVisitaPisoOcasion;
import com.campuslands.inmobiliaria.repositories.RepositoryVisitaVilla;
import com.campuslands.inmobiliaria.repositories.entities.CasaEntity;
import com.campuslands.inmobiliaria.repositories.entities.LocalEntity;
import com.campuslands.inmobiliaria.repositories.entities.PisoNuevoEntity;
import com.campuslands.inmobiliaria.repositories.entities.PisoOcasionEntity;
import com.campuslands.inmobiliaria.repositories.entities.VillaEntity;
import com.campuslands.inmobiliaria.repositories.entities.VisitaCasaEntity;
import com.campuslands.inmobiliaria.repositories.entities.VisitaLocalEntity;
import com.campuslands.inmobiliaria.repositories.entities.VisitaPisoNuevoEntity;
import com.campuslands.inmobiliaria.repositories.entities.VisitaPisoOcasionEntity;
import com.campuslands.inmobiliaria.repositories.entities.VisitaVillaEntity;
import com.campuslands.inmobiliaria.services.InmuebleService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class InmuebleServiceImpl implements InmuebleService{
    
    private final RepositoryCasa repositoryCasa;
    private final CasaDTOConverter casaDTOConverter;
    private final RepositoryVisitaCasa repositoryVisitaCasa;

    private final RepositoryPisoNuevo repositoryPisoNuevo;
    private final PisoNuevoDTOConverter pisoNuevoDTOConverter;
    private final RepositoryVisitaPisoNuevo repositoryVisitaPisoNuevo;

    private final RepositoryPisoOcasion repositoryPisoOcasion;
    private final PisoOcasionDTOConverter pisoOcasionDTOConverter;
    private final RepositoryVisitaPisoOcasion repositoryVisitaPisoOcasion;

    private final RepositoryLocal repositoryLocal;
    private final LocalDTOConverter localDTOConverter;
    private final RepositoryVisitaLocal RepositoryVisitaLocal;

    private final RepositoryVilla repositoryVilla;
    private final VillaDTOConverter villaDTOConverter;
    private final RepositoryVisitaVilla repositoryVisitaVilla;

    @Override
    public CasaDTO saveCasa(CasaDTO casa) {
        CasaEntity casaEntity = casaDTOConverter.convertToEntity(casa);
        CasaEntity savedCasaEntity = repositoryCasa.save(casaEntity);
        return casaDTOConverter.convertToDTO(savedCasaEntity);
    }

    @Override
    public PisoNuevoDTO savePisoN(PisoNuevoDTO pisoN) {
        PisoNuevoEntity pisoNEntity = pisoNuevoDTOConverter.convertToEntity(pisoN);
        PisoNuevoEntity savedPisoNEntity = repositoryPisoNuevo.save(pisoNEntity);
        return pisoNuevoDTOConverter.convertToDTO(savedPisoNEntity);
    }

    @Override
    public PisoOcasionDTO savePisoO(PisoOcasionDTO pisoO) {
        PisoOcasionEntity pisoOcasionEntity = pisoOcasionDTOConverter.convertToEntity(pisoO);
        PisoOcasionEntity savedPisoOcasionEntity = repositoryPisoOcasion.save(pisoOcasionEntity);
        return pisoOcasionDTOConverter.convertToDTO(savedPisoOcasionEntity);
    }

    @Override
    public LocalDTO saveLocal(LocalDTO local) {
        LocalEntity localEntity = localDTOConverter.convertToEntity(local);
        LocalEntity savedLocalEntity = repositoryLocal.save(localEntity);
        return localDTOConverter.convertToDTO(savedLocalEntity);
    }

    @Override
    public VillaDTO saveVilla(VillaDTO villa) {
        VillaEntity villaEntity = villaDTOConverter.convertToEntity(villa);
        VillaEntity savedVillaEntity = repositoryVilla.save(villaEntity);
        return villaDTOConverter.convertToDTO(savedVillaEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public CasaDTO encontrarPorNRcasa(Long numReferencia) {
        CasaEntity casaEntity = repositoryCasa.findById(numReferencia)
                .orElseThrow(() -> new RuntimeException("Casa no encontrada id: " + numReferencia));
        return casaDTOConverter.convertToDTO(casaEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public PisoNuevoDTO encontrarPorNRpisoN(Long numReferencia) {
        PisoNuevoEntity pisoNEntity = repositoryPisoNuevo.findById(numReferencia)
                .orElseThrow(() -> new RuntimeException("Piso nuevo no encontrado id: " + numReferencia));
        return pisoNuevoDTOConverter.convertToDTO(pisoNEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public PisoOcasionDTO encontrarPorNRpisoO(Long numReferencia) {
        PisoOcasionEntity pisoOEntity = repositoryPisoOcasion.findById(numReferencia)
                .orElseThrow(() -> new RuntimeException("Piso ocasion no encontrado id: " + numReferencia));
        return pisoOcasionDTOConverter.convertToDTO(pisoOEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public LocalDTO encontrarPorNRlocal(Long numReferencia) {
        LocalEntity localEntity = repositoryLocal.findById(numReferencia)
                .orElseThrow(() -> new RuntimeException("Local no encontrado id: " + numReferencia));
        return localDTOConverter.convertToDTO(localEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public VillaDTO encontrarPorNRvilla(Long numReferencia) {
        VillaEntity villaEntity = repositoryVilla.findById(numReferencia)
                .orElseThrow(() -> new RuntimeException("Villa no encontrada id: " + numReferencia));
        return villaDTOConverter.convertToDTO(villaEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CasaDTO> listarCasas() {
        List<CasaEntity> casaEntities = (List<CasaEntity>) repositoryCasa.findAll();
        return casaEntities.stream()
                .map(casaDTOConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PisoNuevoDTO> listarPisosN() {
        List<PisoNuevoEntity> pisoNEntities = (List<PisoNuevoEntity>) repositoryPisoNuevo.findAll();
        return pisoNEntities.stream()
                .map(pisoNuevoDTOConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<PisoOcasionDTO> listarPisosO() {
        List<PisoOcasionEntity> pisoOEntities = (List<PisoOcasionEntity>) repositoryPisoOcasion.findAll();
        return pisoOEntities.stream()
                .map(pisoOcasionDTOConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<LocalDTO> listarLocales() {
        List<LocalEntity> localEntities = (List<LocalEntity>) repositoryLocal.findAll();
        return localEntities.stream()
                .map(localDTOConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VillaDTO> listarVillas() {
        List<VillaEntity> villaEntities = (List<VillaEntity>) repositoryVilla.findAll();
        return villaEntities.stream()
                .map(villaDTOConverter::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public VisitaCasaEntity saveVisCasa(VisitaCasaEntity visita) {
        return repositoryVisitaCasa.save(visita);
    }

    @Override
    public VisitaPisoNuevoEntity saveVisPisoN(VisitaPisoNuevoEntity visita) {
        return repositoryVisitaPisoNuevo.save(visita);
    }

    @Override
    public VisitaPisoOcasionEntity saveVisPisoO(VisitaPisoOcasionEntity visita) {
        return repositoryVisitaPisoOcasion.save(visita);
    }

    @Override
    public VisitaLocalEntity saveVisLocal(VisitaLocalEntity visita) {
        return RepositoryVisitaLocal.save(visita);
    }

    @Override
    public VisitaVillaEntity saveVisVilla(VisitaVillaEntity visita) {
        return repositoryVisitaVilla.save(visita);
    }
    
}
