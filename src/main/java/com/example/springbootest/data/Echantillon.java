package com.example.springbootest.data;

/**
 * Classe de données qui permet d'encpsulée de données
 *   * Nombre de voitures
 *   * Prix moyen de ce nombre de voiture(s)
 */
public class Echantillon {

    int nombreDeVoitures;
    int prixMoyen;

    public Echantillon(){}

    public Echantillon(int nombreDeVoitures, int prixMoyen) {
        this.nombreDeVoitures = nombreDeVoitures;
        this.prixMoyen = prixMoyen;
    }

    public int getNombreDeVoitures() {
        return nombreDeVoitures;
    }

    public void setNombreDeVoitures(int nombreDeVoitures) {
        this.nombreDeVoitures = nombreDeVoitures;
    }

    public int getPrixMoyen() {
        return prixMoyen;
    }

    public void setPrixMoyen(int prixMoyen) {
        this.prixMoyen = prixMoyen;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

}