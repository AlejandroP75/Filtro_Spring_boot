package com.campuslands.inmobiliaria.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
import com.campuslands.inmobiliaria.services.InmuebleService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/inmuebles")
@AllArgsConstructor
public class InmuebleController {
    
    private InmuebleService inmuebleService;

    @PostMapping("/casa")
    public ResponseEntity<Object> save(@RequestBody CasaDTO casa){
        try{
            return ResponseEntity.ok(inmuebleService.saveCasa(casa));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/pisoNuevo")
    public ResponseEntity<Object> save(@RequestBody PisoNuevoDTO piso){
        try{
            return ResponseEntity.ok(inmuebleService.savePisoN(piso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/pisoOcasion")
    public ResponseEntity<Object> save(@RequestBody PisoOcasionDTO piso){
        try{
            return ResponseEntity.ok(inmuebleService.savePisoO(piso));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/local")
    public ResponseEntity<Object> save(@RequestBody LocalDTO local){
        try{
            return ResponseEntity.ok(inmuebleService.saveLocal(local));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/villa")
    public ResponseEntity<Object> save(@RequestBody VillaDTO villa){
        try{
            return ResponseEntity.ok(inmuebleService.saveVilla(villa));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("casa/{id}")
    public ResponseEntity<Object> findByIdCasa(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inmuebleService.encontrarPorNRcasa(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @GetMapping("pisoN/{id}")
    public ResponseEntity<Object> findByIdPisoN(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inmuebleService.encontrarPorNRpisoN(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @GetMapping("pisoO/{id}")
    public ResponseEntity<Object> findByPisoO(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inmuebleService.encontrarPorNRpisoO(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @GetMapping("local/{id}")
    public ResponseEntity<Object> findByIdLocal(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inmuebleService.encontrarPorNRlocal(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @GetMapping("villa/{id}")
    public ResponseEntity<Object> findByIdVilla(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(inmuebleService.encontrarPorNRvilla(id));
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }  
    }

    @GetMapping("/casas")
    public ResponseEntity<List<CasaDTO>> findAllC() {
        return ResponseEntity.ok(inmuebleService.listarCasas());
    }

    @GetMapping("/pisosN")
    public ResponseEntity<List<PisoNuevoDTO>> findAllPN() {
        return ResponseEntity.ok(inmuebleService.listarPisosN());
    }

    @GetMapping("/pisosO")
    public ResponseEntity<List<PisoOcasionDTO>> findAllPO() {
        return ResponseEntity.ok(inmuebleService.listarPisosO());
    }

    @GetMapping("/locales")
    public ResponseEntity<List<LocalDTO>> findAllL() {
        return ResponseEntity.ok(inmuebleService.listarLocales());
    }

    @GetMapping("/villas")
    public ResponseEntity<List<VillaDTO>> findAllV() {
        return ResponseEntity.ok(inmuebleService.listarVillas());
    }

    @PostMapping("/visita/casa")
    public ResponseEntity<Object> save(@RequestBody VisitaCasaEntity visita){
        try{
            return ResponseEntity.ok(inmuebleService.saveVisCasa(visita));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/visita/pisoNuevo")
    public ResponseEntity<Object> save(@RequestBody VisitaPisoNuevoEntity visita){
        try{
            return ResponseEntity.ok(inmuebleService.saveVisPisoN(visita));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/visita/pisoOcasion")
    public ResponseEntity<Object> save(@RequestBody VisitaPisoOcasionEntity visita){
        try{
            return ResponseEntity.ok(inmuebleService.saveVisPisoO(visita));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/visitalocal")
    public ResponseEntity<Object> save(@RequestBody VisitaLocalEntity visita){
        try{
            return ResponseEntity.ok(inmuebleService.saveVisLocal(visita));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("visita/villa")
    public ResponseEntity<Object> save(@RequestBody VisitaVillaEntity visita){
        try{
            return ResponseEntity.ok(inmuebleService.saveVisVilla(visita));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
