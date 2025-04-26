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
@Table(name = "Tab_Domanda")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Domanda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Domanda")
    private Long id;

    @Column(name = "descDomanda", nullable = false)
    private String testo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idEsercizio", nullable = false)
    private Esercizio esercizio;

    @OneToMany(mappedBy = "domanda", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OpzioneMultipla> opzioni = new HashSet<>();

    // Getters e Setters
}
