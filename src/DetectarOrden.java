public class DetectarOrden {
    public static void main(String args[]){
        String cadena = "acda";
        boolean escalonada = false;

        for(int i = 0; i<cadena.length()-1;i++){
        
            if(cadena.charAt(i)>=cadena.charAt(i+1)){
                escalonada = false;
                break;
            }
            escalonada = true;
        }
        if(escalonada){
            System.out.println("La cadena esta estalonada");
        }
        else{
            System.out.println("La cadena no esta escalonada");
        }
    }
}
