/*Dada una lista de enteros consecutivos pero con uno faltante, encuentra el número perdido. */

public class RangoPerdido {
    public static void main(String args[]){

        int numeros[] = {1, 2, 3, 4, 6};

        int i = 1;
        while(i<=numeros.length){
            if(numeros[i-1]!=i){
                System.out.println("El número faltante es: " + i);
                break;
            }
            i++;
        }
    }
}
