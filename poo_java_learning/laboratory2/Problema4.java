import java.util.Random;
import java.util.Vector;

public class Problema4 {
    public static void main(String[] args) {

        Vector<Integer> list1 = new Vector<>();
        Vector<Integer> list2 = new Vector<>();

        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        for (int i = 5; i < 15; i++) {
            list2.add(i);
        }

        Vector<Integer> reuniune = new Vector<>();
        Vector<Integer> intersectie = new Vector<>();
        Vector<Integer> diferenta = new Vector<>();

        for (int i = 0; i < list1.size(); i++) {
            if (!reuniune.contains(list1.get(i))) {
                reuniune.add(list1.get(i));
            }
        }
        for (int i = 0; i < list2.size(); i++) {
            if (!reuniune.contains(list2.get(i))) {
                reuniune.add(list2.get(i));
            }
        }

        System.out.println(reuniune);

        for (int i = 0; i < 10; i++){
            if(list1.contains(list2.get(1))){
                intersectie.add(list2.get(i));
            }
        }

        System.out.println(intersectie);

        for (int i = 0; i < 10; i++){
            diferenta.add(list1.get(i));
        }

        for (int i = 0; i < 10; i++){
            if(diferenta.contains(list2.get(i))){
                diferenta.remove(i);
            }
        }

        System.out.println(diferenta);

    }
}