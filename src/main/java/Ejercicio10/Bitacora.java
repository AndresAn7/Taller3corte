/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio10;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Grogu
 */
public class Bitacora {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private final String archivo;

    public Bitacora(String archivo) {
        this.archivo = archivo;
    }

    public void registrar(String mensaje) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo, StandardCharsets.UTF_8, true))) {
            bw.write("[" + LocalDateTime.now().format(FORMATO) + "] " + mensaje);
            bw.newLine();
        }
    }
    
    public List<String> leer() throws IOException {
        List<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo, StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        }
        return lineas;
    }

    public int contar(String palabra) throws IOException {
        int total = 0;
        String buscada = palabra.toLowerCase();
        for (String linea : leer()) {
            if (linea.toLowerCase().contains(buscada)) {
                total++;
            }
        }
        return total;
    }
}