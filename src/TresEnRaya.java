//turno jugador debe alternar quien juega
//el tablero estara ordenado del 1 al 9 para facilidad del usuario

import java.util.Scanner;

public class TresEnRaya {

    public static boolean hayVictoria(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                return true;
            }
        }
        for (int j = 0; j < tablero.length; j++) {
            if (tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                return true;
            }
        }
        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            return true;
        } else if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            return true;
        }
        return false;
    }

    public static void imprimirTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tablero[i][j]);
                if (j != 3 - 1) {
                    System.out.print(" | ");
                }
            }
            System.out.println("");
            if (i != 3 - 1) {
                System.out.println("-".repeat(9));
            }
        }
    }

    public static int[] devolverPosicion(int eleccion) {
        int[] resultado = new int[2];

        int pos = eleccion - 1;
        int fila = pos / 3;
        int columna = pos % 3;

        resultado[0] = fila;
        resultado[1] = columna;

        return resultado;
    };

    public static void main(String args[]) {

        char triqui[][] = { { '1', '2', '3' },
                { '4', '5', '6' },
                { '7', '8', '9' } };

        boolean turnoJugador = true;
        boolean lleno[][] = new boolean[3][3];

        int aux = 1;

        System.out.println("¡Bienvenido! Este es una versión consola de Triqui o Tres en Raya");
        System.out.println(
                "Las casillas estan numeradas del 1 al 9. \n Elije la posición que desees ingresando dicho indice correspondiente. ");
        System.out.println("Tu contrincante va a ser un bot, el nivel: fácil.\n ¡Mucha suerte!");
        System.out.println("Así se ve el tablero:");

        imprimirTablero(triqui);
        
        Scanner sc = new Scanner(System.in);
        int eleccionRandom = (int) ((Math.random() * 9) + 1);


        while (aux < 10) {

            if (turnoJugador) {
                while (true) {
                    System.out.println("Elije tu jugada, ingresa la posición:");
                    int eleccion = 0;
                    try {
                        eleccion = sc.nextInt();
                    } catch (Exception ex) {
                        System.out.println("¡Ingresa un valor númerico entre 1 y 9 por favor!");
                    }
                    int[] coordenadas = devolverPosicion(eleccion);
                    int fila = coordenadas[0];
                    int columna = coordenadas[1];
                    if (!lleno[fila][columna]) {
                        triqui[fila][columna] = 'X';
                        lleno[fila][columna] = true;
                        break;
                    } else {
                        System.out.println("Esa posición ya esta ocupada. Elije otra: ");
                        eleccion = sc.nextInt();
                    }
                }
                System.out.println("Tu elección");
                imprimirTablero(triqui);
                aux++;
            }

            else if (!turnoJugador) {
                while (true) {
                    eleccionRandom = (int) ((Math.random() * 9) + 1);
                    int[] coordenadas = devolverPosicion(eleccionRandom);
                    int fila = coordenadas[0];
                    int columna = coordenadas[1];
                    if (!lleno[fila][columna]) {
                        triqui[fila][columna] = 'O';
                        lleno[fila][columna] = true;
                        break;
                    } else {
                        eleccionRandom = (int) ((Math.random() * 9) + 1);
                    }
                }
                System.out.println("Elección del bot");
                imprimirTablero(triqui);
                aux++;
            }
            turnoJugador = !turnoJugador;
            if (hayVictoria(triqui)) {
                if (!turnoJugador) {
                    System.out.println("¡Felicidades tú ganaste esta ronda!");
                } else {
                    System.out.println("¡Te ganaron! ¡Mejor suerte la próxima!");
                }
                break;
            }
        }
        if(!hayVictoria(triqui) && aux == 10){
            System.out.println("¡Empate!");
        }
    }
}
