//Dada una cadena, cuenta cuántas veces aparece cada letra

public class ContadorLetras {

    public static void main(String args[]){
        String cadena = "zapatos";

        String letras = "abcdefghijklmnñopqrstuvwxyz";
        int i = 0;
        while(i<letras.length()){
            int contador = 0;
            int j = 0;
            while(j<cadena.length()){
                if(letras.charAt(i)==cadena.charAt(j)){
                    contador++;
                }
                j++;
            }
            System.out.println("Letra: "+letras.charAt(i)+". Veces que aparece: "+contador);
            i++;
        }
    }
}
