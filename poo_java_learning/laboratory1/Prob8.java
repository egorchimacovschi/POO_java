import java.util.Random;

public class Prob8 {
    public static void main(String[] args) {
        int n = 12;
        Random random = new Random();
        int[] array = new int[n];
        for (int i = 0; i < n; i++){
            array[i] = random.nextInt(100) + 1;
        }

        for (int i = 0; i < n; i++){
            System.out.printf(array[i] + " ");;
        }
        System.out.println("");

        java.util.Arrays.sort(array);

        for (int i = 0; i < n; i++){
            System.out.printf(array[i] + " ");;
        }
        System.out.println("");

        int pseudoRandomNumber = array[random.nextInt(12) + 1];

        System.out.println(pseudoRandomNumber);

        System.out.println(java.util.Arrays.binarySearch(array, pseudoRandomNumber) + " este indicile la care se afla numarul");
    }
}