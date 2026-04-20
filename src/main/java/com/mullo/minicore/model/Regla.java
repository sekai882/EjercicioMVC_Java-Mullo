package com.mullo.minicore.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "regla")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Regla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Double porcentaje;

    @Column(name = "monto_minimo", nullable = false)
    private Double montoMinimo;

}
