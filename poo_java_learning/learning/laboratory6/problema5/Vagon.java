public abstract class Vagon {
    protected int capacitatePasageri;
    protected int capacitateColete;

    public Vagon(int capacitatePasageri, int capacitateColete) {
        this.capacitateColete = capacitateColete;
        this.capacitatePasageri = capacitatePasageri;
    }

    public int getCapacitateColete() {
        return capacitateColete;
    }

    public int getCapacitatePasageri() {
        return capacitatePasageri;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
