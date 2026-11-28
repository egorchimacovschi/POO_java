import java.util.LinkedList;
import java.util.Collection;
import java.util.Set;

class LinkedSet extends LinkedList<Object> implements Set<Object> {
    @Override
    public boolean add(Object obj) {
        if (contains(obj)) {
            return false;
        }

        return super.add(obj);
    }

    @Override
    public void add(int index, Object obj) {
        if (contains(obj)) {
            return;
        }

        super.add(index, obj);
    }

    @Override
    public Object set(int index, Object object) {
        int pos = indexOf(object);
        if (pos != -1 && pos != index) {
            throw new IllegalArgumentException(object + "exista deja pe pozitia " + pos);
        }

        return super.set(index, object);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;

        if (!(object instanceof Collection))
            return false;

        Collection<?> other = (Collection<?>) object;
        return size() == other.size() && containsAll(other);
    }

    @Override
    public int hashCode() {
        int h = 0;

        for (Object e : this) {
            if (e != null)
                h += e.hashCode();
        }

        return h;
    }

}
