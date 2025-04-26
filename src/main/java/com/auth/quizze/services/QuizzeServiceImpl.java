package com.auth.quizze.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.auth.quizze.repository.QuizRepository;
import java.util.List;

@Service
public class QuizzeServiceImpl implements QuizzeService {
    
    @Autowired
    private QuizRepository quizRepository;

    @Override
    public void insertEsercizio(String nome, String descrizione) {
        quizRepository.insertEsercizio(nome, descrizione);
    }

    @Override
    public void insertDomanda(String testo, Long esercizioId) {
        quizRepository.insertDomanda(testo, esercizioId);
    }

    @Override
    public void insertOpzioneMultipla(String testo, boolean corretta, Long domandaId) {
        quizRepository.insertOpzioneMultipla(testo, corretta, domandaId);
    }

    @Override
    public void insertRisposta(String testo, boolean corretta, Long domandaId) {
        quizRepository.insertRisposta(testo, corretta, domandaId);
    }

    @Override
    public List<Object[]> findAllEserciziWithDomandeAndOpzioni() {
        return quizRepository.findAllEserciziWithDomandeAndOpzioni();
    }

    @Override
    public List<Object[]> findEsercizioWithDomandeAndOpzioni(Long esercizioId) {
        return quizRepository.findEsercizioWithDomandeAndOpzioni(esercizioId);
    }

    @Override
    public List<Object[]> findDomandaWithOpzioni(Long domandaId) {
        return quizRepository.findDomandaWithOpzioni(domandaId);
    }

    @Override
    public List<Object[]> getEserciziDomandeOpzioni() {
        return quizRepository.getEserciziDomandeOpzioni();
    }

    @Override
    public List<Object[]> getEsercizioDomandeOpzioniById(Long esercizioId) {
        return quizRepository.getEsercizioDomandeOpzioniById(esercizioId);
    }

    @Override
    public Boolean isRispostaCorretta(Long opzioneId) {
        return quizRepository.isRispostaCorretta(opzioneId);
    }

    @Override
    public List<Object[]> verificaRispostaConDettagli(Long opzioneId) {
        return quizRepository.verificaRispostaConDettagli(opzioneId);
    }
}
