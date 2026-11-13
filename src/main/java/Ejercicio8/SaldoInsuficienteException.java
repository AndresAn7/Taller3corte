/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

import java.util.Locale;

/**
 *
 * @author Grogu
 */
public class SaldoInsuficienteException extends Exception {
    
    private final double saldo;
    private final double faltante;

    public SaldoInsuficienteException(double saldo, double faltante) {
        super("Saldo insuficiente. Saldo: " + formato(saldo) + " - Faltan: " + formato(faltante));
        this.saldo = saldo;
        this.faltante = faltante;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getFaltante() {
        return faltante;
    }

    static String formato(double valor) {
        return "$" + String.format(Locale.US, "%,.0f", valor).replace(',', '.');
    }
   
}
