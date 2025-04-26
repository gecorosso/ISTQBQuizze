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
@Table(name = "TabMultipla")

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OpzioneMultipla {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMultipla")
    private Long id;

    @Column(name = "descMultipla", nullable = false)
    private String testo;

    @Column(name = "esatto", nullable = false)
    private boolean corretta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Domanda", nullable = false)
    private Domanda domanda;

    // Getters e Setters
}
