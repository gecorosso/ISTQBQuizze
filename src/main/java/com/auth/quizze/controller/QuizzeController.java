package com.auth.quizze.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/quizze")
public class QuizzeController {
	
	//Post Seleziona l'esercizio 
//    @PostMapping (value = "/seleziona-esercizio", consumes = "application/json", produces = "application/json")
//    @Operation(summary = "Seleziona l'esercizio", description = "Seleziona l'esercizio.")
//	public ResponseEntity<Domande> selezionaEsercizio(@RequestBody Domande domande) {
//		// Logica per selezionare l'esercizio
//		// Restituisci una risposta appropriata
//		return new ResponseEntity<>(domande, HttpStatus.OK);
//	}
	
	/*@PostMapping(value = "/create", consumes = "application/json", produces = "application/json")
	    @Operation(summary = "Crea un nuovo prodotto", description = "Crea un nuovo prodotto.")
		public ResponseEntity<Prodotti> createProdotto(@RequestBody Prodotti prodotto) {
			Prodotti nuovoProdotto = prodottiServices.saveProdotti(prodotto);
	        return new ResponseEntity<>(nuovoProdotto, HttpStatus.CREATED);
	    }*/
	
	
	
	//Get Output Domanda Esegue la domanda con le risposte multiple
	//Post Inpt Risposta utente
	//Get Output Statistiche risposte totali , corrette e Sbagliate
	
}
