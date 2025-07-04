/*Escalera de asteriscos
Imprime una pirámide con n niveles. */

public class EscaleraAsteriscos {
    public static void main(String args[]) {

        int n = 10;
        int base = (n * 2)-1;

        for (int i = 1; i <= base; i++) {
            if (i % 2 != 0) {
                System.out.println(" ".repeat((base - i)/2) + "*".repeat(i) + " ".repeat((base - i)/2));
            }
        }

    }
}
