import java.util.Collections;
import java.util.Vector;

public class Test {
    public static void main(String[] args) {
        Vector<Student> vector = new Vector<>();

        vector.add(new Student("Egor", 9.18, 9.20, 9.30));
        vector.add(new Student("Egor", 9.20, 9.40, 9.30));
        vector.add(new Student("Egor", 10, 10.10, 10.2));

        Collections.sort(vector);

        System.out.println(vector);
    }
}
