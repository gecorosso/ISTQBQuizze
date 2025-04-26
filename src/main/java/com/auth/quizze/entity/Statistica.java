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
@Table(name = "Tab_Statistica")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Statistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStatistica")
    private Long id;

    @Column(name = "nomeUtente", nullable = false)
    private String nomeUtente;

    @Column(name = "data", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "rispEsatte", nullable = false)
    private int risposteEsatte;

    @Column(name = "rispSbagliate", nullable = false)
    private int risposteSbagliate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEsercizio", nullable = false)
    private Esercizio esercizio;

    @OneToMany(mappedBy = "statistica", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Risposta> risposte = new HashSet<>();

    // Getters e Setters
}