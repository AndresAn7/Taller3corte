/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio8;

/**
 *
 * @author Grogu
 */
public class CuentaBancaria {
   
    private double saldo;

    public CuentaBancaria(double saldoInicial) {
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }
    
        public void depositar(double monto) throws MontoInvalidoException {
        validar(monto);
        saldo += monto;
    }
   
        
        public void retirar(double monto) throws MontoInvalidoException, SaldoInsuficienteException {
        validar(monto);
        if (monto > saldo) {
            throw new SaldoInsuficienteException(saldo, monto - saldo);
        }
        saldo -= monto;
    }

    private void validar(double monto) throws MontoInvalidoException {
        if (Double.isNaN(monto) || Double.isInfinite(monto) || monto <= 0) {
            throw new MontoInvalidoException(monto);
        }
    }

}
