package com.example.springbootest.service;

import com.example.springbootest.data.Voiture;

public interface Statistique {

    void ajouter(Voiture voiture);

    Echantillon prixMoyen() throws ArithmeticException;

}