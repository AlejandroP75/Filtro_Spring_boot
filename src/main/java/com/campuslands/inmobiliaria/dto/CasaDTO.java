package com.campuslands.inmobiliaria.dto;

import com.campuslands.inmobiliaria.repositories.entities.TipoContratoEnum;
import com.campuslands.inmobiliaria.repositories.entities.TipoGasEnum;

import lombok.Data;

@Data
public class CasaDTO {
    
    private Long numReferencia;

    private float m2;

    private String direccion;

    private String nomPropietario;

    private String telefonoPropietario;

    private Boolean llaves;

    private TipoContratoEnum tipoContrato;

    private int precio;

    private Long habitaciones;

    private Long baños;

    private Long aseos;

    private Long cocinas;

    private TipoGasEnum tipoGas;

    private Boolean puertaBlindada;

    private int parqueaderos;

    private Long id_oficina;

    private Long id_zona;
}
