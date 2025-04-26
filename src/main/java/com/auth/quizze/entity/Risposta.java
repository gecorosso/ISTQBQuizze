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
@Table(name = "Tab_Risposte")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Risposta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRisposte")
    
    
    
    
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idStatistica", nullable = false)
    private Statistica statistica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idMultipla", nullable = false)
    private OpzioneMultipla opzione;

    // Getters e Setters
}