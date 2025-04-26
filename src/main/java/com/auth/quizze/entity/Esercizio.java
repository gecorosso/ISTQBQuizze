package com.auth.quizze.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "Tab_Esercizio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Esercizio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEsercizio")
    private Long id;

    @Column(name = "desEsercizio", nullable = false)
    private String descrizione;

    @Column(name = "domandeTot", nullable = false)
    private int totaleDomande;

    @OneToMany(mappedBy = "esercizio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Domanda> domande = new HashSet<>();

    @OneToMany(mappedBy = "esercizio", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Statistica> statistiche = new HashSet<>();

    //Getters e Setter
				
}		




	


	
