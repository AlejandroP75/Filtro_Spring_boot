package com.campuslands.inmobiliaria.repositories.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
@Table(name = "locales")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LocalEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numReferencia;

    @Column(nullable = false)
    @NotEmpty(message = "El tamaño de la local no puede estar vacio")
    private float m2;

    @Column(nullable = false)
    @NotEmpty(message = "La direccion de la local no puede estar vacio")
    private String direccion;

    @Column(nullable = false)
    @NotEmpty(message = "El nombre del propietario no puede estar vacio")
    private String nomPropietario;

    @Column(nullable = false)
    @NotEmpty(message = "El telefono del propietario no puede estar vacio")
    private String telefonoPropietario;

    @Column(nullable = false)
    @NotEmpty(message = "El indicador de llaves tiene que ser true o false")
    private Boolean llaves;

    @Column(nullable = false)
    @NotEmpty(message = "El tipo de contrato no puede estar vacio")
    @Enumerated(EnumType.ORDINAL)
    private TipoContratoEnum tipoContrato;

    @Column(nullable = false)
    @NotEmpty(message = "El precio de la local no puede estar vacio")
    private int precio;

    @Column(nullable = false)
    @NotEmpty(message = "El numero de puertas de la local no puede estar vacio")
    private int numeroPuertas;

    @Column(nullable = false)
    @NotEmpty(message = "Si en o no diafano de la local no puede estar vacio")
    private boolean diafano;

    @Column(nullable = false)
    @NotEmpty(message = "Si esta o no acondicionado de la local no puede estar vacio")
    private boolean acondicionado;

    @JoinColumn(name = "id_oficina")
    @ManyToOne(fetch = FetchType.LAZY)
    private OficinaEntity oficina;

    @JoinColumn(name = "id_zona")
    @ManyToOne(fetch = FetchType.LAZY)
    private ZonaEntity zona;

    @OneToMany(mappedBy = "local", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VisitaLocalEntity> visitas;
}
