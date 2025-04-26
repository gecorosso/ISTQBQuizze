package com.auth.quizze.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.auth.quizze.services.QuizzeService;
import java.util.List;

@RestController
@RequestMapping("/quizze")
public class QuizzeController {

    @Autowired
    private QuizzeService quizzeService;

    // Insert endpoints
    @PostMapping("/esercizio")
    public ResponseEntity<Void> insertEsercizio(@RequestParam String nome, @RequestParam String descrizione) {
        quizzeService.insertEsercizio(nome, descrizione);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/domanda")
    public ResponseEntity<Void> insertDomanda(@RequestParam String testo, @RequestParam Long esercizioId) {
        quizzeService.insertDomanda(testo, esercizioId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/opzione")
    public ResponseEntity<Void> insertOpzioneMultipla(
            @RequestParam String testo, 
            @RequestParam boolean corretta, 
            @RequestParam Long domandaId) {
        quizzeService.insertOpzioneMultipla(testo, corretta, domandaId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/risposta")
    public ResponseEntity<Void> insertRisposta(
            @RequestParam String testo, 
            @RequestParam boolean corretta, 
            @RequestParam Long domandaId) {
        quizzeService.insertRisposta(testo, corretta, domandaId);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Query endpoints
    @GetMapping("/all")
    public ResponseEntity<List<Object[]>> getAllEserciziWithDomandeAndOpzioni() {
        return ResponseEntity.ok(quizzeService.findAllEserciziWithDomandeAndOpzioni());
    }

    @GetMapping("/esercizio/{esercizioId}")
    public ResponseEntity<List<Object[]>> getEsercizioWithDomandeAndOpzioni(@PathVariable Long esercizioId) {
        return ResponseEntity.ok(quizzeService.findEsercizioWithDomandeAndOpzioni(esercizioId));
    }

    @GetMapping("/domanda/{domandaId}")
    public ResponseEntity<List<Object[]>> getDomandaWithOpzioni(@PathVariable Long domandaId) {
        return ResponseEntity.ok(quizzeService.findDomandaWithOpzioni(domandaId));
    }

    @GetMapping("/dettagli")
    public ResponseEntity<List<Object[]>> getEserciziDomandeOpzioni() {
        return ResponseEntity.ok(quizzeService.getEserciziDomandeOpzioni());
    }

    @GetMapping("/dettagli/{esercizioId}")
    public ResponseEntity<List<Object[]>> getEsercizioDomandeOpzioniById(@PathVariable Long esercizioId) {
        return ResponseEntity.ok(quizzeService.getEsercizioDomandeOpzioniById(esercizioId));
    }

    // Verification endpoints
    @GetMapping("/verifica/{opzioneId}")
    public ResponseEntity<Boolean> isRispostaCorretta(@PathVariable Long opzioneId) {
        return ResponseEntity.ok(quizzeService.isRispostaCorretta(opzioneId));
    }

    @GetMapping("/verifica/dettagli/{opzioneId}")
    public ResponseEntity<List<Object[]>> verificaRispostaConDettagli(@PathVariable Long opzioneId) {
        return ResponseEntity.ok(quizzeService.verificaRispostaConDettagli(opzioneId));
    }
}
