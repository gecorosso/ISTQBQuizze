package com.auth.quizze.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.auth.quizze.entity.Domanda;


public interface QuizRepository extends JpaRepository<Domanda, Long> {
    @Query(value = "INSERT INTO esercizio (nome, descrizione) VALUES (:nome, :descrizione)", nativeQuery = true)
    void insertEsercizio(@Param("nome") String nome, @Param("descrizione") String descrizione);
        
    @Query(value = "INSERT INTO domanda (testo, esercizio_id) VALUES (:testo, :esercizioId)", nativeQuery = true)
    void insertDomanda(@Param("testo") String testo, @Param("esercizioId") Long esercizioId);
    
    @Query(value = "INSERT INTO opzione_multipla (testo, corretta, domanda_id) VALUES (:testo, :corretta, :domandaId)", nativeQuery = true)
    void insertOpzioneMultipla(@Param("testo") String testo, @Param("corretta") boolean corretta, @Param("domandaId") Long domandaId);

    @Query(value = "INSERT INTO risposta (testo, corretta, domanda_id) VALUES (:testo, :corretta, :domandaId)", nativeQuery = true)
    void insertRisposta(@Param("testo") String testo, @Param("corretta") boolean corretta, @Param("domandaId") Long domandaId);
    
	
    @Query(value = "SELECT e.*, d.*, om.* FROM esercizio e " +
           "LEFT JOIN domanda d ON d.esercizio_id = e.id " +
           "LEFT JOIN opzione_multipla om ON om.domanda_id = d.id", nativeQuery = true)
    List<Object[]> findAllEserciziWithDomandeAndOpzioni();

    @Query(value = "SELECT e.*, d.*, om.* FROM esercizio e " +
           "LEFT JOIN domanda d ON d.esercizio_id = e.id " +
           "LEFT JOIN opzione_multipla om ON om.domanda_id = d.id " +
           "WHERE e.id = :esercizioId", nativeQuery = true)
    List<Object[]> findEsercizioWithDomandeAndOpzioni(@Param("esercizioId") Long esercizioId);

    @Query(value = "SELECT e.*, d.*, om.* FROM esercizio e " +
           "LEFT JOIN domanda d ON d.esercizio_id = e.id " +
           "LEFT JOIN opzione_multipla om ON om.domanda_id = d.id " +
           "WHERE d.id = :domandaId", nativeQuery = true)
    List<Object[]> findDomandaWithOpzioni(@Param("domandaId") Long domandaId);

    @Query(value = "SELECT CASE WHEN om.corretta = true THEN true ELSE false END " +
           "FROM opzione_multipla om " +
           "WHERE om.id = :opzioneId", nativeQuery = true)
    Boolean isRispostaCorretta(@Param("opzioneId") Long opzioneId);

    @Query(value = "SELECT om.corretta, om.testo, d.testo as domanda_testo " +
           "FROM opzione_multipla om " +
           "JOIN domanda d ON d.id = om.domanda_id " +
           "WHERE om.id = :opzioneId", nativeQuery = true)
    List<Object[]> verificaRispostaConDettagli(@Param("opzioneId") Long opzioneId);

    @Query(value = "SELECT " +
           "e.id as esercizio_id, e.nome as esercizio_nome, e.descrizione as esercizio_desc, " +
           "d.id as domanda_id, d.testo as domanda_testo, " +
           "om.id as opzione_id, om.testo as opzione_testo, om.corretta " +
           "FROM esercizio e " +
           "LEFT JOIN domanda d ON d.esercizio_id = e.id " +
           "LEFT JOIN opzione_multipla om ON om.domanda_id = d.id " +
           "ORDER BY e.id, d.id, om.id", nativeQuery = true)
    List<Object[]> getEserciziDomandeOpzioni();

    @Query(value = "SELECT " +
           "e.id as esercizio_id, e.nome as esercizio_nome, e.descrizione as esercizio_desc, " +
           "d.id as domanda_id, d.testo as domanda_testo, " +
           "om.id as opzione_id, om.testo as opzione_testo, om.corretta " +
           "FROM esercizio e " +
           "LEFT JOIN domanda d ON d.esercizio_id = e.id " +
           "LEFT JOIN opzione_multipla om ON om.domanda_id = d.id " +
           "WHERE e.id = :esercizioId " +
           "ORDER BY d.id, om.id", nativeQuery = true)
    List<Object[]> getEsercizioDomandeOpzioniById(@Param("esercizioId") Long esercizioId);
}