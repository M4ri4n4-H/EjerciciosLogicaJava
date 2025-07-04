public class Duplicados {

    public static void main(String args[]) {
        int[] duplicados = {3, 5, 3, 2, 5, 6, 7};
        int noDuplicados = 0;

        for(int i = 0; i<duplicados.length;i++){
            int contador = 0;
            for(int j = 0; j<duplicados.length;j++){
                if(duplicados[i]==duplicados[j]){
                    contador++;
                }
            }
            if(contador==1){
                noDuplicados = duplicados[i];
                System.out.println(noDuplicados);
            }
        }
    }
}
