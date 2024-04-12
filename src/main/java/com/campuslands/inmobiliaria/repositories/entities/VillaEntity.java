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
@Table(name = "villas")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VillaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numReferencia;

    @Column(nullable = false)
    @NotEmpty(message = "El tamaño de la villa no puede estar vacio")
    private float m2;

    @Column(nullable = false)
    @NotEmpty(message = "La direccion de la villa no puede estar vacio")
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
    @NotEmpty(message = "El precio de la villa no puede estar vacio")
    private int precio;

    @Column(nullable = false)
    @NotEmpty(message = "Las habitaciones de la villa no puede estar vacio")
    private Long habitaciones;

    @Column(nullable = false)
    @NotEmpty(message = "Los baños de la villa no puede estar vacio")
    private Long baños;

    @Column(nullable = false)
    @NotEmpty(message = "Los aseos de la villa no puede estar vacio")
    private Long aseos;

    @Column(nullable = false)
    @NotEmpty(message = "Las cocinas de la villa no puede estar vacio")
    private Long cocinas;

    @Column(nullable = false)
    @NotEmpty(message = "El tipo de gas de la villa no puede estar vacio")
    @Enumerated(EnumType.ORDINAL)
    private TipoGasEnum tipoGas;

    @Column(nullable = false)
    @NotEmpty(message = "El inidcador de si tiene puerta blindada de la villa no puede estar vacio")
    private Boolean puertaBlindada;

    @Column(nullable = false)
    @NotEmpty(message = "Los parqueaderos de la villa no puede estar vacio")
    private int parqueaderos;

    @Column(nullable = false)
    @NotEmpty(message = "El tamaño de parcela de la villa no puede estar vacio")
    private float tamañoParcela;

    @Column(nullable = false)
    @NotEmpty(message = "La urbalizacion de la villa no puede estar vacio")
    private String urbanizacion;

    @JoinColumn(name = "id_oficina")
    @ManyToOne(fetch = FetchType.LAZY)
    private OficinaEntity oficina;

    @OneToMany(mappedBy = "villa", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VisitaVillaEntity> visitas;
}
