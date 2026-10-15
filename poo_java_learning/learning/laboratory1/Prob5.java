public class Prob5{
    public static void main(String[] args) {

        Prob5 obiect = new Prob5();

        int rezultat = obiect.powInt(4, 3);
        double rezultatMath = Math.pow(4, 3);

        System.out.println("4^3 = " + rezultat);
        System.out.println("Math.pow(4, 3) = " + rezultatMath);

        if (rezultat == rezultatMath) {
            System.out.println("egale");
        } else {
            System.out.println("diferite");
        }
    }

    int powInt(int baza, int exp){
        if (exp == 0){
            return 1;
        }

        return baza * powInt(baza, exp -1);
    }
}