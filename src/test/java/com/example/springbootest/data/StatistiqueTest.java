
package com.example.springbootest.data;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.example.springbootest.data.Voiture;
import com.example.springbootest.data.Echantillon;
import com.example.springbootest.data.StatistiqueImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

    @SpringBootTest
    public class StatistiqueTest {

        @Test
        void when_ajouter_voiture_should_increase_internal_list_size() {
            // Arrange
            StatistiqueImpl statistique = new StatistiqueImpl();
            Voiture voiture = new Voiture("Renault", 10000);

            // Act
            statistique.ajouter(voiture);
            Echantillon echantillon = statistique.prixMoyen();

            // Assert
            Assertions.assertEquals(1, echantillon.getNombreDeVoitures(), "Le nombre de voitures doit être 1");
        }

        @Test
        void when_calculating_prix_moyen_should_return_correct_average() {
            // Arrange
            StatistiqueImpl statistique = new StatistiqueImpl();
            statistique.ajouter(new Voiture("Renault", 10000));
            statistique.ajouter(new Voiture("Peugeot", 20000));
            statistique.ajouter(new Voiture("Citroen", 30000));

            // Act
            Echantillon echantillon = statistique.prixMoyen();

            // Assert
            Assertions.assertEquals(3, echantillon.getNombreDeVoitures(), "Le nombre de voitures doit être 3");
            Assertions.assertEquals(20000, echantillon.getPrixMoyen(), "La moyenne doit être 20000");
        }

        @Test
        void when_no_voitures_should_throw_arithmetic_exception() {
            // Arrange
            StatistiqueImpl statistique = new StatistiqueImpl();

            // Assert
            Assertions.assertThrows(ArithmeticException.class, statistique::prixMoyen, "Doit lancer une ArithmeticException");
        }

        @Test
        void when_ajouter_multiple_voitures_should_calculate_correct_average() {
            // Arrange
            StatistiqueImpl statistique = new StatistiqueImpl();
            statistique.ajouter(new Voiture("Ferrari", 50000));
            statistique.ajouter(new Voiture("Lamborghini", 60000));

            // Act
            Echantillon echantillon = statistique.prixMoyen();

            // Assert
            Assertions.assertEquals(2, echantillon.getNombreDeVoitures(), "Le nombre de voitures doit être 2");
            Assertions.assertEquals(55000, echantillon.getPrixMoyen(), "La moyenne doit être 55000");
        }

        @Test
        void when_adding_same_price_voitures_should_return_same_average() {
            // Arrange
            StatistiqueImpl statistique = new StatistiqueImpl();
            statistique.ajouter(new Voiture("Audi", 25000));
            statistique.ajouter(new Voiture("BMW", 25000));

            // Act
            Echantillon echantillon = statistique.prixMoyen();

            // Assert
            Assertions.assertEquals(2, echantillon.getNombreDeVoitures(), "Le nombre de voitures doit être 2");
            Assertions.assertEquals(25000, echantillon.getPrixMoyen(), "La moyenne doit être 25000");
        }
    }

