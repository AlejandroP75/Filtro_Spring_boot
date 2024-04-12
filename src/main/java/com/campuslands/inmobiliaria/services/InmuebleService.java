package com.campuslands.inmobiliaria.services;

import java.util.List;

import com.campuslands.inmobiliaria.dto.CasaDTO;
import com.campuslands.inmobiliaria.dto.LocalDTO;
import com.campuslands.inmobiliaria.dto.PisoNuevoDTO;
import com.campuslands.inmobiliaria.dto.PisoOcasionDTO;
import com.campuslands.inmobiliaria.dto.VillaDTO;
import com.campuslands.inmobiliaria.repositories.entities.VisitaCasaEntity;
import com.campuslands.inmobiliaria.repositories.entities.VisitaLocalEntity;
import com.campuslands.inmobiliaria.repositories.entities.VisitaPisoNuevoEntity;
import com.campuslands.inmobiliaria.repositories.entities.VisitaPisoOcasionEntity;
import com.campuslands.inmobiliaria.repositories.entities.VisitaVillaEntity;

public interface InmuebleService {
    
    CasaDTO saveCasa(CasaDTO casa);

    PisoNuevoDTO savePisoN(PisoNuevoDTO pisoN);

    PisoOcasionDTO savePisoO(PisoOcasionDTO pisoO);

    LocalDTO saveLocal(LocalDTO local);

    VillaDTO saveVilla(VillaDTO villa);

    CasaDTO encontrarPorNRcasa(Long numReferencia);

    PisoNuevoDTO encontrarPorNRpisoN(Long numReferencia);

    PisoOcasionDTO encontrarPorNRpisoO(Long numReferencia);

    LocalDTO encontrarPorNRlocal(Long numReferencia);

    VillaDTO encontrarPorNRvilla(Long numReferencia);

    List<CasaDTO> listarCasas();

    List<PisoNuevoDTO> listarPisosN();

    List<PisoOcasionDTO> listarPisosO();

    List<LocalDTO> listarLocales();

    List<VillaDTO> listarVillas();

    VisitaCasaEntity saveVisCasa(VisitaCasaEntity visita);

    VisitaPisoNuevoEntity saveVisPisoN(VisitaPisoNuevoEntity visita);

    VisitaPisoOcasionEntity saveVisPisoO(VisitaPisoOcasionEntity visita);

    VisitaLocalEntity saveVisLocal(VisitaLocalEntity visita);

    VisitaVillaEntity saveVisVilla(VisitaVillaEntity visita);
}
