package com.auth.quizze.services;

import java.util.List;

public interface QuizzeService {
    // Insert methods
    void insertEsercizio(String nome, String descrizione);
    void insertDomanda(String testo, Long esercizioId);
    void insertOpzioneMultipla(String testo, boolean corretta, Long domandaId);
    void insertRisposta(String testo, boolean corretta, Long domandaId);
    
    // Query methods for viewing exercises, questions and options
    List<Object[]> findAllEserciziWithDomandeAndOpzioni();
    List<Object[]> findEsercizioWithDomandeAndOpzioni(Long esercizioId);
    List<Object[]> findDomandaWithOpzioni(Long domandaId);
    
    // Detailed view methods
    List<Object[]> getEserciziDomandeOpzioni();
    List<Object[]> getEsercizioDomandeOpzioniById(Long esercizioId);
    
    // Answer verification methods
    Boolean isRispostaCorretta(Long opzioneId);
    List<Object[]> verificaRispostaConDettagli(Long opzioneId);
}
