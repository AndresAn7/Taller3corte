/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio4;

/**
 *
 * @author Grogu
 */

public class Main {

    public static void main(String[] args) {
        Dispositivo[] tienda = {
            new Smartphone("Samsung", "Galaxy S24", 3500000, 50),
            new Camara("Canon", "EOS R50", 4200000, 24),
            new Smartphone("Xiaomi", "Redmi Note 11 Pro", 1300000, 108)
        };

        int mayorResolucion = 0;

        for (Dispositivo d : tienda) {
            System.out.println(d.describir());

            if (d instanceof Fotografiable) {
                Fotografiable f = (Fotografiable) d;
                f.tomarFoto();
                mayorResolucion = Math.max(mayorResolucion, f.getMegapixeles());
            }
            if (d instanceof Llamable) {
                Llamable l = (Llamable) d;
                l.llamar("3001234569");
                l.colgar();
            }
            System.out.println();
        }

        System.out.println("Mayor resolución: " + mayorResolucion + " MP");
    }
}
