package com.campuslands.inmobiliaria.repositories.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "oficinas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OficinaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre de la oficina no puede estar vacio")
    private String nombre;
    
    @JoinColumn(name = "id_zona")
    @ManyToOne(fetch = FetchType.LAZY)
    private ZonaEntity zona;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PisoNuevoEntity> pisosNuevos;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<PisoOcasionEntity> pisosOcasion;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<CasaEntity> casa;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<LocalEntity> locales;

    @OneToMany(mappedBy = "oficina", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<VillaEntity> villas;
}
