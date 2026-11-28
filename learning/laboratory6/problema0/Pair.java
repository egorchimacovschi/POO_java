public class Pair {

    private Object object1, object2;

    public Pair(Object object1, Object object2) {
        this.object1 = object1;
        this.object2 = object2;
    }

    public Object getObjectFirst() {
        return object1;
    }

    public Object getObjectSecond() {
        return object2;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (!(object instanceof Pair))
            return false;
        Pair other = (Pair) object;
        return object1.equals(other.object1) && object2.equals(other.object2);
    }

    @Override
    public String toString() {
        return "(" + object1 + ", " + ")";
    }
}
