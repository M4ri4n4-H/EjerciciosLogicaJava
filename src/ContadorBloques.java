public class ContadorBloques {
    public static void main(String[] args) {
        int numeros[] = { 2, 2, 2, 4, 5, 5, 5, 5, 6, 6 };

        int i = 0;
        int mayor = 0;
        int num = 0;

        while (i < numeros.length) {
            int actual = numeros[i];
            int j = i + 1;
            int contador = 1;
            while (j < numeros.length && actual == numeros[j]) {
                contador++;
                j++;
            }
            i = j;

            if (contador > mayor) {
                mayor = contador;
                num = actual;
            }
        }
        System.out.println("veces que se repite: "+mayor+" Numero: "+num);

    }
}
