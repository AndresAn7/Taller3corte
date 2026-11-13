/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Ejercicio8;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 *
 * @author Grogu
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CuentaBancaria cuenta = new CuentaBancaria(500000);
        boolean salir = false;

        try {
            while (!salir) {
                System.out.println("1. Consultar 2. Depositar 3. Retirar 4. Salir");
                System.out.print("Opción: ");
                try {
                    int opcion = Integer.parseInt(sc.nextLine().trim());
                    switch (opcion) {
                        case 1:
                            System.out.println("Saldo actual: " + SaldoInsuficienteException.formato(cuenta.getSaldo()));
                            break;
                        case 2:
                            System.out.print("Monto a depositar: ");
                            double deposito = Double.parseDouble(sc.nextLine().trim());
                            cuenta.depositar(deposito);
                            System.out.println("Depósito exitoso. Saldo: " + SaldoInsuficienteException.formato(cuenta.getSaldo()));
                            break;
                        case 3:
                            System.out.print("Monto a retirar: ");
                            double retiro = Double.parseDouble(sc.nextLine().trim());
                            cuenta.retirar(retiro);
                            System.out.println("Retiro exitoso. Saldo: " + SaldoInsuficienteException.formato(cuenta.getSaldo()));
                            break;
                        case 4:
                            System.out.println("Gracias por usar el cajero. Hasta pronto!");
                            salir = true;
                            break;
                        default:
                            System.out.println("Opción no válida. Elija de 1 a 4.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: debe ingresar un número.");
                } catch (MontoInvalidoException e) {
                    System.out.println(e.getMessage());
                } catch (SaldoInsuficienteException e) {
                    System.out.println(e.getMessage());
                }
                System.out.println();
            }
        } catch (NoSuchElementException e) {
            System.out.println("Se terminó la entrada de datos. Hasta pronto.");
        } finally {
            sc.close();
        }
    }
}