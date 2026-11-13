/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author Grogu
 */
public class Smartphone extends Dispositivo implements Llamable, Fotografiable {

    private final int megapixeles;

    public Smartphone(String marca, String modelo, double precio, int megapixeles) {
        super(marca, modelo, precio);
        this.megapixeles = megapixeles;
    }

    @Override
    public void llamar(String numero) {
        System.out.println(marca + " llamando a " + numero);
    }

    @Override
    public void colgar() {
        System.out.println(marca + " finalizó la llamada");
    }

    @Override
    public void tomarFoto() {
        System.out.println(marca + " tomó una foto de " + megapixeles + " MP");
    }

    @Override
    public int getMegapixeles() {
        return megapixeles;
    }

    // Resuelve la ambigüedad de los dos default funcion().
    @Override
    public String funcion() {
        return Llamable.super.funcion() + " y " + Fotografiable.super.funcion().toLowerCase();
    }

    @Override
    public String describir() {
        return "Smartphone " + marca + " " + modelo + " - " + precioFormateado() + " - " + funcion();
    }
}