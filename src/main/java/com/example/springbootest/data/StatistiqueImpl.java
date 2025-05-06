package com.example.springbootest.data;

import com.example.springbootest.data.Voiture;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StatistiqueImpl implements com.example.springbootest.data.Statistique {

    List<Voiture> voitures = new ArrayList<Voiture>();

    @Override
    public void ajouter(Voiture voiture) {
        voitures.add(voiture);
    }

    @Override
    public com.example.springbootest.data.Echantillon prixMoyen() throws ArithmeticException {
        int prixTotal = 0;
        int nombreDeVoitures = 0;
        Iterator<Voiture> iterator = voitures.iterator();
        while(iterator.hasNext()){
            prixTotal = (int) (prixTotal + iterator.next().getPrix());
            nombreDeVoitures++;
        }
        return new com.example.springbootest.data.Echantillon(nombreDeVoitures, prixTotal/nombreDeVoitures);
    }

}