/*Desplaza cada letra de un mensaje por una cantidad fija.
Ej: "hola" con desplazamiento 1 → "ipmb" */

public class CodigoSecreto {
    public static void main(String args[]){

        String cadena = "zapato";
        String letras = "abcdefghijklmnñopqrstuvwxyz";
        String encriptado = "";

        for(int i = 0; i<cadena.length();i++){
            for(int j = 0; j<letras.length();j++){

                if(cadena.charAt(i) == 'z' && letras.charAt(j) == 'z'){
                    encriptado += letras.charAt(0);
                }
                else if(cadena.charAt(i)==letras.charAt(j)){
                    encriptado += letras.charAt(j+1);
                }
            }
        }
        System.out.println(encriptado);
        
    }
}
