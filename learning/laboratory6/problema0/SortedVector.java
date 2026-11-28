import java.util.*;

class SortedVector<T> extends Vector<T> {
    private Comparator<? super T> comparator;

    public SortedVector(Comparator<? super T> comparator) {
        this.comparator = comparator;
    }

    public SortedVector() {
        this(null);
    }

    @Override
    public boolean add(T object) {
        super.add(object);
        Collections.sort(this, comparator);
        return true;
    }
}
