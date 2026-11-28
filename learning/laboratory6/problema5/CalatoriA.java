public class CalatoriA extends Vagon implements UsiAutomate {
    public CalatoriA() {
        super(40, 300);
    }

    @Override
    public void deschideUsi() {
        System.out.println("CalatoriA: usile se deschid automat.");
    }

    @Override
    public void inchideUsi() {
        System.out.println("CalatoriA: usile se inchid automat.");
    }
}
