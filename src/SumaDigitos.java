public class SumaDigitos {

    public static int sumaDigitos(int numero){
        String cadena = String.valueOf(numero);
        int aux = 0;
        int suma = 0;

        while(aux<cadena.length()){
            suma += Character.getNumericValue(cadena.charAt(aux)); //este metodo sirve para pasar de char a int
            aux++;
        }
        return suma;
    }
    public static void main(String args[]){

        int numero = 123;
        System.out.println(sumaDigitos(numero));
    }
}
