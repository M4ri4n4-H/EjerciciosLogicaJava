/*Programa donde el usuario adivina un número secreto. 
El programa da pistas (“más alto” o “más bajo”) */

import java.util.Scanner;

public class AdivinaNumero {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        int intentos = 5;
        int numeroSecreto = (int) (Math.random() * 9) + 1;
        int num = 0;

        while (intentos > 0) {

            try {
                System.out.println("Adivina el numero de 1 al 10. Tienes "+intentos+" intento(s)");
                num = sc.nextInt();
            } catch (Exception ex) {
                System.out.println("Ingrese un valor válido! ");
            }
            intentos--;


            if (num == numeroSecreto) {
                System.out.println("Felicidades! Adivinaste al " + (5-intentos) + " intento(s)");
                break;
            } else if (num < numeroSecreto) {
                System.out.println("El número que ingresaste es menor");
            } else if (num > numeroSecreto) { 
                System.out.println("El número que ingresaste es mayor");
            }
        }
        if (intentos == 0) {
            System.out.println("Lo siento te quedaste sin intentos");
        }

        sc.close();
    }
}
