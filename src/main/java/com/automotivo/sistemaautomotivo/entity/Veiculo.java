package com.automotivo.sistemaautomotivo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id; 
    private String modelo;
    private String status;
    private Double preco;
    private int ano;
    private Long quilometragem;
    private String cor;

    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
}
