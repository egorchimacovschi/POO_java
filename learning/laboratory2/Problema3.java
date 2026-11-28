import java.util.Random;
import java.util.Vector;

public class Problema3 {
    public static void main(String[] args) {
        Vector<Integer> list = new Vector<>();
        Random generator = new Random();
        for (int i = 0; i < 20; i++) {
            list.add(generator.nextInt(10));
        }
        System.out.println(list);

        int removed = eliminareAparitie(1, list);
        System.out.println(list);
        System.out.println("Removed: " + removed);

        int max = list.get(0);
        int min = list.get(0);
        int sum = 0;

        for (int i = 0; i < list.size(); i++) {
            int value = list.get(i);
            if (value > max)
                max = value;
            if (value < min)
                min = value;
            sum += value;
        }
        float media = (float) sum / list.size();

        System.out.println("max = " + max + ", min = " + min + ", media = " + media);
    }

    static int eliminareAparitie(int x, Vector<Integer> list) {
        int count = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) == x) {
                list.remove(i);
                count++;
            }
        }
        return count;
    }
}