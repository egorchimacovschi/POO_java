public class Prob6{
    public static void main(String[] args) {
        Prob6 obiect = new Prob6();
        for (int i = 1; i < 21; i++){
            if(obiect.isPrime(i)){
                System.out.println(i + " prim");
            } else{
                System.out.println(i + " nu e prim");
            }
        }
    }

    static boolean isPrime(int n){
        if (n < 0) return false;
        else if (n == 1) return true;
        else {
            for (int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    return false;
                }
            }

            return true;
        }
    }
}