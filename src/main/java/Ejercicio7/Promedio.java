/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio7;

import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Grogu
 */
public class Promedio {

    static int leerEntero(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim();
            try {
                int n = Integer.parseInt(texto);
                if (n <= 0) {
                    System.out.println("Debe ser un número mayor que cero.");
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido: escriba un número entero.");
            }
        }
    }

    static double leerNota(Scanner sc, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String texto = sc.nextLine().trim().replace(',', '.');
            try {
                double nota = Double.parseDouble(texto);
                if (!(nota >= 0 && nota <= 5)) {  
                    System.out.println("La nota debe estar entre 0 y 5.");
                    continue;
                }
                return nota;
            } catch (NumberFormatException e) {
                System.out.println("Dato inválido: escriba un número (ej. 4.5).");
            }
        }
    }

    static double promedio(double[] notas) {
        if (notas == null || notas.length == 0) {
            throw new IllegalArgumentException("Debe haber al menos una nota.");
        }
        double suma = 0;
        for (int i = 0; i < notas.length; i++) { 
            suma += notas[i];
        }
        return suma / notas.length; 
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = leerEntero(sc, "¿Cuántas notas? ");
            double[] notas = new double[n];
            for (int i = 0; i < n; i++) {
                notas[i] = leerNota(sc, "Nota " + (i + 1) + ": ");
            }
            System.out.println("Promedio: " + String.format(Locale.US, "%.2f", promedio(notas)));
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println("Se terminó la entrada de datos.");
        }
    }
}
