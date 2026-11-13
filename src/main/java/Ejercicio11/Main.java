/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Locale;

/**
 *
 * @author Grogu
 */
public class Main {

    static final int COLUMNAS = 5;
    static final double NOTA_MINIMA_APROBAR = 3.0;

    static double leerNota(String texto, String campo) {
        double nota;
        try {
            nota = Double.parseDouble(texto.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(campo + " '" + texto.trim() + "' no es un número");
        }
        if (!(nota >= 0 && nota <= 5)) {
            throw new IllegalArgumentException(campo + " " + texto.trim() + " está fuera del rango 0-5");
        }
        return nota;
    }

    public static void main(String[] args) {
        int procesados = 0;
        int errores = 0;

        try (BufferedReader br = Files.newBufferedReader(Paths.get("notas.csv"), StandardCharsets.UTF_8);
             BufferedWriter bw = Files.newBufferedWriter(Paths.get("reporte.csv"), StandardCharsets.UTF_8)) {

            bw.write("codigo,nombre,promedio,estado");
            bw.newLine();

            br.readLine();
            int numeroLinea = 1;
            String linea;

            while ((linea = br.readLine()) != null) {
                numeroLinea++;
                if (linea.trim().isEmpty()) {
                    continue;
                }
                String[] c = linea.split(",", -1);
                try {
                    if (c.length != COLUMNAS) {
                        throw new IllegalArgumentException(
                                "se esperaban " + COLUMNAS + " columnas y hay " + c.length);
                    }
                    double n1 = leerNota(c[2], "nota1");
                    double n2 = leerNota(c[3], "nota2");
                    double n3 = leerNota(c[4], "nota3");

                    double promedio = (n1 + n2 + n3) / 3;
                    String estado = promedio >= NOTA_MINIMA_APROBAR ? "APROBADO" : "REPROBADO";

                    bw.write(c[0].trim() + "," + c[1].trim() + ","
                            + String.format(Locale.US, "%.2f", promedio) + "," + estado);
                    bw.newLine();
                    procesados++;
                } catch (IllegalArgumentException e) {
                    System.out.println("Línea " + numeroLinea + " omitida: " + e.getMessage());
                    errores++;
                }
            }

            System.out.println();
            System.out.println("Registros procesados: " + procesados);
            System.out.println("Registros con error: " + errores);
            System.out.println("Reporte generado en reporte.csv");

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró notas.csv en la carpeta del proyecto.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}