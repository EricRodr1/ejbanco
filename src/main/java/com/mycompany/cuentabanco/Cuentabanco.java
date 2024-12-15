/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.cuentabanco;
import java.util.Scanner;

public class Cuentabanco {
    public String cliente;
    public int numcuenta;
    public String celular;
    public float limite;
    private float saldo = 0;
    Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Cuentabanco cuenta = new Cuentabanco();
        cuenta.ingresarDatos();

         
        System.out.print("Ingrese el monto a depositar: ");
        float deposito = cuenta.sc.nextFloat();
        cuenta.depositar(deposito);
        System.out.println("Saldo luego de depositar: " + cuenta.getSaldo());

        System.out.print("Ingrese el monto a retirar: ");
        float retiro = cuenta.sc.nextFloat();
        cuenta.retirar(retiro);
        System.out.println("Saldo luego de retirar: " + cuenta.getSaldo());
    }

    public Cuentabanco() {
        this.limite = 999999;
        this.saldo = 0;
    }

    public float getSaldo() {
        return saldo;
    }

    public void depositar(float monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido, porfavor intente de nuevo");
            sc.close();
        } else if ((saldo + monto) > this.limite) {
            System.out.println("Monto invalido, porfavor intente de nuevo");
            sc.close();
        } else {
            saldo += monto;
            System.out.println("Cantidad depositada ");
        }
    }

    public void retirar(float monto) {
        if (monto <= 0) {
            System.out.println("Monto invalido, porfavor intente de nuevo");
            sc.close();
        } else if ((saldo - monto) < 0) {
            System.out.println("Monto invalido, porfavor intente de nuevo");
            sc.close(); 
        } else {
            saldo -= monto;
            System.out.println("Cantidad retirada");
        }
    }

    public void ingresarDatos() {
        System.out.print("Ingrese su nombre: ");
        this.cliente = sc.nextLine();

        System.out.print("Ingrese su numero de cuenta: ");
        this.numcuenta = sc.nextInt();
        sc.nextLine();

        System.out.print("Ingrese su telefono: ");
        this.celular = sc.nextLine();

        System.out.println("Gracias por llenar!");
    }
}

