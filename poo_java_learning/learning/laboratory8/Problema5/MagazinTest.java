public class MagazinTest {

    private static int passed = 0;
    private static int failed = 0;

    public static void main(String[] args) {
        testAdaugaProdus();
        testReducereStocMic();
        testLimitaStoc50();
        testReducereIdempotenta();
        testValidari();
        testAfisareInventar();

        System.out.println();
        System.out.println("Trecute: " + passed + ", picate: " + failed);
        if (failed > 0) {
            System.exit(1);
        }
    }

    static void testAdaugaProdus() {
        Magazin m = new Magazin();
        m.adaugaProdus("P001", "Laptop", 3499.99, 12);

        Magazin.Produs p = m.getProdus("P001");
        check("produs adaugat", p != null);
        check("nume corect", "Laptop".equals(p.getNume()));
        check("pret vechi = pret nou initial", p.getPretVechi() == p.getPretNou());
        check("neredus initial", !p.isRedus());
        check("cod inexistent => null", m.getProdus("XXX") == null);
    }

    static void testReducereStocMic() {
        Magazin m = new Magazin();
        m.adaugaProdus("P001", "Laptop", 3499.99, 12);
        m.adaugaProdus("P002", "Mouse", 59.90, 150);
        m.adaugaProdus("P003", "Tastatura", 100.00, 49);
        m.aplicaReduceriStocMic();

        check("laptop redus", m.getProdus("P001").isRedus());
        check("laptop 3499.99 -> 2974.99", m.getProdus("P001").getPretNou() == 2974.99);
        check("tastatura 100 -> 85.00", m.getProdus("P003").getPretNou() == 85.00);
        check("mouse (stoc 150) nereudus", !m.getProdus("P002").isRedus());
        check("mouse pret neschimbat", m.getProdus("P002").getPretNou() == 59.90);
        check("pret vechi ramane", m.getProdus("P001").getPretVechi() == 3499.99);
    }

    static void testLimitaStoc50() {
        Magazin m = new Magazin();
        m.adaugaProdus("A", "Stoc49", 100, 49);
        m.adaugaProdus("B", "Stoc50", 100, 50);
        m.adaugaProdus("C", "Stoc0", 100, 0);
        m.aplicaReduceriStocMic();

        check("stoc 49 redus", m.getProdus("A").isRedus());
        check("stoc 50 NU redus", !m.getProdus("B").isRedus());
        check("stoc 0 redus", m.getProdus("C").isRedus());
    }

    static void testReducereIdempotenta() {
        Magazin m = new Magazin();
        m.adaugaProdus("A", "Produs", 100, 10);
        m.aplicaReduceriStocMic();
        m.aplicaReduceriStocMic();
        check("a doua aplicare nu scade din nou", m.getProdus("A").getPretNou() == 85.00);
    }

    static void testValidari() {
        Magazin m = new Magazin();
        checkThrows("nume null", () -> m.adaugaProdus("A", null, 10, 1));
        checkThrows("nume vid", () -> m.adaugaProdus("A", "   ", 10, 1));
        checkThrows("pret negativ", () -> m.adaugaProdus("A", "X", -1, 1));
        checkThrows("stoc negativ", () -> m.adaugaProdus("A", "X", 10, -1));
        checkThrows("cod vid", () -> m.adaugaProdus("", "X", 10, 1));

        m.adaugaProdus("D", "Dublu", 10, 1);
        checkThrows("cod duplicat", () -> m.adaugaProdus("D", "Altul", 5, 1));

        m.adaugaProdus("Z", "Gratis", 0, 0);
        check("pret 0 si stoc 0 acceptate", m.getProdus("Z") != null);
    }

    static void testAfisareInventar() {
        Magazin m = new Magazin();
        m.adaugaProdus("P001", "Laptop", 3499.99, 12);
        m.adaugaProdus("P002", "Mouse", 59.90, 150);
        m.adaugaProdus("P003", "Tastatura", 129.49, 49);
        m.aplicaReduceriStocMic();
        System.out.println("--- Inventar (verificare vizuala, 2 zecimale) ---");
        m.afiseazaInventar();
    }

    // ---- utilitare ----

    static void check(String name, boolean condition) {
        if (condition) {
            passed++;
            System.out.println("[OK]   " + name);
        } else {
            failed++;
            System.out.println("[FAIL] " + name);
        }
    }

    static void checkThrows(String name, Runnable action) {
        try {
            action.run();
            failed++;
            System.out.println("[FAIL] " + name + " (nu a aruncat exceptie)");
        } catch (IllegalArgumentException e) {
            passed++;
            System.out.println("[OK]   " + name);
        }
    }
}
