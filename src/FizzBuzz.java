/*FizzBuzz con regla personalizada
Imprime números del 1 al 50. Si es múltiplo de 3 escribe “Fuzz”,
 si es de 5 “Buzz”, si es de ambos “FuzzBuzz”. */

public class FizzBuzz {
    public static void main(String args[]){

        int i = 1;
        while(i<51){
            if(i%3==0 && i%5==0){
                System.out.println("FizzBuzz");
            }
            else if(i%3==0){
                System.out.println("Fizz");
            }
            else if(i%5==0){
                System.out.println("Buzz");
            }
            else{
                System.out.println(i);
            }
            i++;
        }
    }
}
