public class Prob7 {
    public static void main(String[] args) {
        Prob7 object = new Prob7();

        object.ipotezaGoldbach(14);
    }

    void ipotezaGoldbach(int n){

        Prob6 object  = new Prob6();

        for(int p = 2; p <= 2 * n; p+= 2){
            for(int a = 1; a <= p / 2; a++){
                int b = p - a;
                if (object.isPrime(a) && object.isPrime(b)){
                    System.out.println(p + " = " + a + " + " + b);
                }
            }
        }
    }
}