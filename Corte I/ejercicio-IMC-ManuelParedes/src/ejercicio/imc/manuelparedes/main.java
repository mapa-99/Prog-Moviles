/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio.imc.manuelparedes;

import java.util.Scanner;

/**
 *
 * @author estudiante
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Ingrsa tu altura (decimal con ,)...");

        Float altura = input.nextFloat();
        System.out.println("Ingrsa tu peso (decimal con ,)...");
        Float peso = input.nextFloat();

        float imc = peso / (altura * altura);
        clasificar(imc);

    }

    public static void clasificar(float imc) {
        System.out.println("Tienes una IMC de: " + imc);

        if (imc < 18.5) {
            System.out.println("Tienes bajo peso!");
        } else if (imc > 18.5 && imc < 24.9) {
            System.out.println("Tienes un peso normal!");

        } else if (imc > 25.0 && imc < 29.9) {
            System.out.println("Tienes sobrepeso!");

        } else {
            System.out.println("Estás obeso!");

        }
    }

}
