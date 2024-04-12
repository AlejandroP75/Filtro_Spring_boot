package com.campuslands.inmobiliaria.repositories.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "visitasPisoNuevo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitaPisoNuevoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotEmpty(message = "La fecha y hora de la visita no puede estar vacia")
    @Temporal(TemporalType.DATE)
    private LocalDate fechaHora;

    @Column(nullable = false)
    @NotEmpty(message = "El comentario de la visita no puede estar vacio")
    private String comentario;

    @ManyToOne()
    @JoinColumn(name = "id_pisoNuevo")
    private PisoNuevoEntity pisoNuevo;

    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private ClienteEntity cliente;
}
