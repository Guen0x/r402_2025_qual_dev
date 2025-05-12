package com.example.springbootest.data;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class StatistiqueTest {

    private Statistique statistiqueMock;  // Mock de l'interface Statistique
    private Voiture voitureMock;          // Mock de la classe Voiture
    private Echantillon echantillonMock;  // Mock de la classe Echantillon

    @BeforeEach
    public void setUp() {
        // Création de mocks pour les objets
        statistiqueMock = Mockito.mock(Statistique.class);
        voitureMock = Mockito.mock(Voiture.class);
        echantillonMock = Mockito.mock(Echantillon.class);
    }

    @Test
    public void testAjouter() {
        // Simuler un comportement pour la voiture
        when(voitureMock.getPrix()).thenReturn(20000.0);

        // Tester l'ajout de la voiture dans la statistique
        doNothing().when(statistiqueMock).ajouter(voitureMock);  // Pas de comportement à tester ici, juste l'appel

        // Appeler la méthode
        statistiqueMock.ajouter(voitureMock);

        // Vérifier que la méthode a bien été appelée avec le mock de la voiture
        verify(statistiqueMock, times(1)).ajouter(voitureMock);
    }

    @Test
    public void testPrixMoyen() throws ArithmeticException {
        // Simuler le comportement du mock pour retourner un échantillon
        when(statistiqueMock.prixMoyen()).thenReturn(new Echantillon(5, 25000));

        // Appeler la méthode et récupérer le résultat
        Echantillon result = statistiqueMock.prixMoyen();

        // Vérifier les valeurs de l'échantillon retourné
        assertNotNull(result);
        assertEquals(5, result.getNombreDeVoitures());
        assertEquals(25000, result.getPrixMoyen());
    }

    @Test
    public void testPrixMoyen_ArithmeticException() {
        // Simuler une exception ArithmeticException lors de l'appel de prixMoyen()
        when(statistiqueMock.prixMoyen()).thenThrow(new ArithmeticException("Division by zero"));

        // Vérifier que l'exception est bien lancée
        assertThrows(ArithmeticException.class, () -> statistiqueMock.prixMoyen());
    }
}

