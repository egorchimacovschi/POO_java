import java.util.Comparator;

public class Comp1 implements Comparator<Pair> {

    @SuppressWarnings("unchecked")
    @Override
    public int compare(Pair pair1, Pair pair2) {
        Comparable c1 = (Comparable) pair1.getObjectFirst();
        Comparable c2 = (Comparable) pair2.getObjectFirst();
        return c1.compareTo(c2);
    }
}
