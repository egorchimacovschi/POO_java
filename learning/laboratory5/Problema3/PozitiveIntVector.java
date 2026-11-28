import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class PozitiveIntVector {
    static Vector<Integer> numereIntregi = new Vector<Integer>(100);

    static void myRead(Scanner scanner) throws NumarNegativ {
        while (true) {
            int temp = scanner.nextInt();
            if (temp < 0) {
                throw new NumarNegativ();
            }
            numereIntregi.add(temp);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            myRead(scanner);
        } catch (NumarNegativ e) {
            System.out.println(e.getMessage());
        }

        if (!numereIntregi.isEmpty()) {
            int max = Collections.max(numereIntregi);
            System.out.println("The max value is: " + max);
        }
    }
}

class NumarNegativ extends Exception {
    public NumarNegativ() {
        super("Numarul introdus este negativ!");
    }
}