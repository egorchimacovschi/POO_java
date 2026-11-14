public class CalatoriB extends Vagon implements UsiAutomate, GeamuriAutomate {
    public CalatoriB() {
        super(50, 400);
    }

    @Override
    public void deschideUsi() {
        System.out.println("CalatoriB: usile se deschid automat.");
    }

    @Override
    public void inchideUsi() {
        System.out.println("CalatoriB: usile se inchid automat.");
    }

    @Override
    public void blocheazaGeamuri() {
        System.out.println("CalatoriB: geamurile se blocheaza automat.");
    }
}
