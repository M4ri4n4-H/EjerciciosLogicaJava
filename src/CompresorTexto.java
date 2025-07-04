public class CompresorTexto {

    public static void main(String[] args) {
        String cadena = "aaabbbaaa";
        String compresor = "";

        int i = 0;

        while (i < cadena.length()) {

            char actual = cadena.charAt(i);
            int j = i + 1;
            int contador = 1;
            while (j < cadena.length() && actual==cadena.charAt(j)) {
                contador++;
                j++;
            }
            i=j;
            compresor += String.valueOf(actual)+Integer.toString(contador);
        }
        System.out.println(compresor);
    }
}
