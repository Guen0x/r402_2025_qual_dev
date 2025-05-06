package com.example.springbootest.data;

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.springbootest.data.Echantillon;
import com.example.springbootest.data.Voiture;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
public class StatistiqueTest {

    @MockBean
    Statistique mockStatistique;

    @Test
    public void Test_prix_moyen() {
        // Arrange
        Echantillon fakeEchantillon = new Echantillon();
        fakeEchantillon.setPrixMoyen(25000);  // Suppose que setMoyenne existe

        when(mockStatistique.prixMoyen()).thenReturn(fakeEchantillon);

        // Act
        Echantillon resultat = mockStatistique.prixMoyen();

        // Assert
        assertEquals(25000.0, resultat.getPrixMoyen(), "La moyenne des prix doit être 25000.0");
    }




}
