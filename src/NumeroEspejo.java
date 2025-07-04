public class NumeroEspejo {
    public static void main(String args[]) {
        int numero = 123321;
        String cadena = Integer.toString(numero);

        boolean condicion = false;
        int j = 0;

        for (int i = 0; i < (cadena.length()) / 2; i++) {

            j = cadena.length()-1-i;//indice espejo

            if (cadena.charAt(i) == cadena.charAt(j)) {
                condicion = true;
            } else {
                condicion = false;
                break;
            }
        }
        System.out.println(condicion);
    }
}
