package com.campuslands.inmobiliaria.dto;

import com.campuslands.inmobiliaria.repositories.entities.TipoContratoEnum;

import lombok.Data;

@Data
public class LocalDTO {
    
    private Long numReferencia;

    private float m2;

    private String direccion;

    private float tamañoParcela;

    private String urbanizacion;

    private String nomPropietario;

    private String telefonoPropietario;

    private Boolean llaves;

    private TipoContratoEnum tipoContrato;

    private int numeroPuertas;

    private boolean diafano;

    private boolean acondicionado;

    private Long id_oficina;

    private Long id_zona;
}
