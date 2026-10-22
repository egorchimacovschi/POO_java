class Numar {
    int num;

    public Numar() {
        this.num = 0;
    }

    public int suma(int a) {
        return this.num + a;
    }

    public int suma(int a, int b) {
        return a + suma(b);
    }

    public int suma(int a, int b, int c) {
        return a + suma(b, c);
    }

    public int suma(int a, int b, int c, int d) {
        return a + suma(b, c, d);
    }

    public static void main(String[] args) {
        Numar numar = new Numar();

        System.out.println(numar.suma(1));
        System.out.println(numar.suma(1, 2));
        System.out.println(numar.suma(1, 2, 3));
        System.out.println(numar.suma(1, 2, 3, 4));
    }
}