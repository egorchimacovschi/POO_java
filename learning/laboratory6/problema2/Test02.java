public class Test02 {
    public static void main(String[] args) {
        // Conversie 1
        Circle c1 = new Circle();
        Shape s1 = c1;
        Square sq;
        if (s1 instanceof Square) {
            sq = (Square) s1;
        } else {
            sq = null;
            System.out.println("Conversie 1: c1 nu este Square, conversia nu este posibila.");
        }
        // Conversie 2
        Rectangle r = new Rectangle(5.0, 5.0);
        if (r instanceof Square) {
            sq = (Square) r;
        } else {
            System.out.println("Conversie 2: r nu este Square, conversia nu este posibila.");
        }

        // Conversie 3
        sq = new Square(7.0);
        r = sq;
        System.out.println("Conversie 3 reusita: " + r);
    }
}
