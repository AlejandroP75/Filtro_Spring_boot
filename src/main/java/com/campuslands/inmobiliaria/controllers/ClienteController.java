package com.campuslands.inmobiliaria.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campuslands.inmobiliaria.repositories.entities.ClienteEntity;
import com.campuslands.inmobiliaria.services.ClienteService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/clientes")
@AllArgsConstructor
public class ClienteController {
    
    private ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody ClienteEntity cliente){
        try{
            return ResponseEntity.ok(clienteService.saveCliente(cliente));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody ClienteEntity cliente){
        try {
            return ResponseEntity.ok(clienteService.updateCliente(id, cliente));
            
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
