import java.util.Vector;

public class Tren implements Comparable<Tren> {
    private Vector<Vagon> vagoane;

    public Tren() {
        vagoane = new Vector<>();
    }

    public void addVagon(Vagon v) {
        vagoane.add(v);
    }

    public int getNumarTotalColete() {
        int total = 0;

        for (Vagon vagon : vagoane) {
            total += vagon.getCapacitateColete();
        }

        return total;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Tren cu ").append(vagoane.size()).append(" vagoane:\n");

        for (Vagon v : vagoane) {
            sb.append(" - ").append(v.getClass().getSimpleName()).append("\n");
        }

        sb.append("Capacitate totala colete: ").append(getNumarTotalColete());

        return sb.toString();
    }

    @Override
    public int compareTo(Tren other) {
        return Integer.compare(this.getNumarTotalColete(), other.getNumarTotalColete());
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (!(obj instanceof Tren))
            return false;

        Tren tren = (Tren) obj;

        return this.getNumarTotalColete() == tren.getNumarTotalColete();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(getNumarTotalColete());
    }
}
