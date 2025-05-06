package com.example.springbootest.data;
import com.example.springbootest.data.Voiture;

public interface Statistique {

    public void ajouter(Voiture voiture);

    public com.example.springbootest.data.Echantillon prixMoyen() throws ArithmeticException;

}