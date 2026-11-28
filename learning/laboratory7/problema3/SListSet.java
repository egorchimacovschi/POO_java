import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.SortedSet;

public class SListSet extends LinkedList implements SortedSet {

    private final Comparator comparator;

    public SListSet() {
        this(null);
    }

    public SListSet(Comparator cmp) {
        super();
        this.comparator = cmp;
    }

    private void check(Object o) {
        if (o == null) {
            throw new NullPointerException("SListSet nu accepta valori null");
        }
        if (comparator == null && !(o instanceof Comparable)) {
            throw new ClassCastException("Fara comparator, elementele trebuie sa fie Comparable; "
                    + o.getClass().getName() + " nu este");
        }
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    private int compare(Object a, Object b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        return ((Comparable) a).compareTo(b);
    }

    @Override
    public Comparator comparator() {
        return comparator;
    }

    @Override
    public boolean add(Object o) {
        check(o);
        ListIterator it = listIterator();
        while (it.hasNext()) {
            int c = compare(it.next(), o);
            if (c == 0) {
                return false;
            }
            if (c > 0) {
                it.previous();
                break;
            }
        }
        it.add(o);
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean changed = false;
        for (Object o : c) {
            changed |= add(o);
        }
        return changed;
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Multimea este goala");
        }
        return super.getFirst();
    }

    @Override
    public Object last() {
        if (isEmpty()) {
            throw new java.util.NoSuchElementException("Multimea este goala");
        }
        return super.getLast();
    }

    @Override
    public SortedSet subSet(Object from, Object to) {
        check(from);
        check(to);
        if (compare(from, to) > 0) {
            throw new IllegalArgumentException("from > to");
        }
        SListSet r = new SListSet(comparator);
        for (Object o : this) {
            if (compare(o, from) >= 0 && compare(o, to) < 0) {
                r.addLast(o);
            }
        }
        return r;
    }

    @Override
    public SortedSet headSet(Object to) {
        check(to);
        SListSet r = new SListSet(comparator);
        for (Object o : this) {
            if (compare(o, to) >= 0) {
                break;
            }
            r.addLast(o);
        }
        return r;
    }

    @Override
    public SortedSet tailSet(Object from) {
        check(from);
        SListSet r = new SListSet(comparator);
        for (Object o : this) {
            if (compare(o, from) >= 0) {
                r.addLast(o);
            }
        }
        return r;
    }

    @Override
    public SListSet reversed() {
        SListSet r = new SListSet(Collections.reverseOrder(comparator));
        Iterator it = descendingIterator();
        while (it.hasNext()) {
            r.addLast(it.next());
        }
        return r;
    }

    @Override
    public void add(int index, Object element) {
        throw new UnsupportedOperationException("Pozitia este data de ordonare");
    }

    @Override
    public boolean addAll(int index, Collection c) {
        throw new UnsupportedOperationException("Pozitia este data de ordonare");
    }

    @Override
    public Object set(int index, Object element) {
        throw new UnsupportedOperationException("Pozitia este data de ordonare");
    }

    @Override
    public void addFirst(Object o) {
        add(o);
    }

    @Override
    public boolean offer(Object o) {
        return add(o);
    }

    @Override
    public boolean offerFirst(Object o) {
        return add(o);
    }

    @Override
    public boolean offerLast(Object o) {
        return add(o);
    }

    @Override
    public void push(Object o) {
        add(o);
    }

    @Override
    public void addLast(Object o) {
        check(o);
        if (!isEmpty() && compare(super.getLast(), o) >= 0) {
            add(o);
        } else {
            super.addLast(o);
        }
    }
}
