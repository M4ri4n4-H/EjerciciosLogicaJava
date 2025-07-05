import java.util.Scanner;

public class TriquiContraAmigo {

    public static void limpiarTablero(char[][] tablero) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tablero[i][j] = ' ';
            }
        }
    }

    public static boolean hayVictoria(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i][0] == 'X' && tablero[i][1] == 'X' && tablero[i][2] == 'X') {
                return true;
            } else if (tablero[i][0] == 'O' && tablero[i][1] == 'O' && tablero[i][2] == 'O') {
                return true;
            }
        }
        for (int j = 0; j < tablero.length; j++) {
            if (tablero[0][j] == 'X' && tablero[1][j] == 'X' && tablero[2][j] == 'X') {
                return true;
            } else if (tablero[0][j] == 'O' && tablero[1][j] == 'O' && tablero[2][j] == 'O') {
                return true;
            }
        }
        if (tablero[0][0] == 'X' && tablero[1][1] == 'X' && tablero[2][2] == 'X') {
            return true;
        }
        if (tablero[0][0] == 'O' && tablero[1][1] == 'O' && tablero[2][2] == 'O') {
            return true;
        } else if (tablero[0][2] == 'X' && tablero[1][1] == 'X' && tablero[2][0] == 'X') {
            return true;
        } else if (tablero[0][2] == 'O' && tablero[1][1] == 'O' && tablero[2][0] == 'O') {
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

        System.out.println("¡Bienvenidos! Este es una versión consola de Triqui o Tres en Raya");
        System.out.println(
                "Las casillas estan numeradas del 1 al 9. \n Elijan la posición que deseen ingresando el índice correspondiente. ");
        System.out.println("¡Mucha suerte!");
        System.out.println("Así se ve el tablero:");

        imprimirTablero(triqui);
        limpiarTablero(triqui);

        Scanner sc = new Scanner(System.in);

        while (aux < 10) {

            if (turnoJugador) {
                while (true) {
                    System.out.println("Jugador 1, ingresa tu jugada:");
                    int eleccion = 0;
                    try {
                        eleccion = sc.nextInt();
                    } catch (Exception ex) {
                        System.out.println("¡Ingresa un valor númerico entre 1 y 9 por favor!");
                    }
                   while (true) {
                        if (eleccion < 1 || eleccion > 9) {
                            System.out.println("¡Ingresa un valor válido!");
                            eleccion = sc.nextInt();
                        } else {
                            break;
                        }
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
                System.out.println("Elección del jugador 1:");
                imprimirTablero(triqui);
                aux++;
            }

            else if (!turnoJugador) {
                while (true) {
                    System.out.println("Jugador 2, ingresa tu jugada:");
                    int eleccion = 0;
                    try {
                        eleccion = sc.nextInt();
                    } catch (Exception ex) {
                        System.out.println("¡Ingresa un valor númerico entre 1 y 9 por favor!");
                    }
                   while (true) {
                        if (eleccion < 1 || eleccion > 9) {
                            System.out.println("¡Ingresa un valor válido!");
                            eleccion = sc.nextInt();
                        } else {
                            break;
                        }
                    }
                    int[] coordenadas = devolverPosicion(eleccion);
                    int fila = coordenadas[0];
                    int columna = coordenadas[1];
                    if (!lleno[fila][columna]) {
                        triqui[fila][columna] = 'O';
                        lleno[fila][columna] = true;
                        break;
                    } else {
                        System.out.println("Esa posición ya esta ocupada. Elije otra: ");
                        eleccion = sc.nextInt();
                    }
                }
                System.out.println("Elección del jugador 2:");
                imprimirTablero(triqui);
                aux++;
            }
            turnoJugador = !turnoJugador;
            if (hayVictoria(triqui)) {
                if (!turnoJugador) {
                    System.out.println("¡Felicidades jugador 1, ganaste!");
                } else {
                    System.out.println("¡Felicidades jugador 2, ganaste!");
                }
                break;
            }
        }
        if (!hayVictoria(triqui) && aux == 10) {
            System.out.println("¡Empate!");
        }
    }
}
