import java.util.Comparator;

public class Comp2 implements Comparator<Pair> {

    @SuppressWarnings("unchecked")
    @Override
    public int compare(Pair pair1, Pair pair2) {
        Comparable c1 = (Comparable) pair1.getObjectSecond();
        Comparable c2 = (Comparable) pair2.getObjectSecond();
        return c1.compareTo(c2);
    }
}
