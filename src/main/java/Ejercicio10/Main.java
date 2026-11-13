/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio10;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Grogu
 */
public class Main {

    public static void main(String[] args) {

        new File("bitacora.txt").delete();

        try {
            Bitacora bitacora = new Bitacora("bitacora.txt");
            bitacora.registrar("Sistema iniciado correctamente");
            bitacora.registrar("ERROR: no se pudo conectar con la base de datos");
            bitacora.registrar("Usuario admin inició sesión");
            bitacora.registrar("Error: archivo de configuración corrupto");

            System.out.println("=== Contenido de bitacora.txt ===");
            for (String linea : bitacora.leer()) {
                System.out.println(linea);
            }
            System.out.println("Total de errores: " + bitacora.contar("error"));

            System.out.println();
            System.out.println("=== Intentando leer un archivo inexistente ===");
            new Bitacora("noexiste.txt").leer();
        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo 'noexiste.txt'. Verifique el nombre y la carpeta.");
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}