import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Magazin {

    public static class Produs {
        private final String nume;
        private final double pretVechi;
        private double pretNou;
        private final int stoc;
        private boolean redus;

        public Produs(String nume, double pret, int stoc) {
            if (nume == null || nume.trim().isEmpty())
                throw new IllegalArgumentException("Numele nu poate fi nul sau vid");

            if (pret < 0)
                throw new IllegalArgumentException("Pretul trebuie sa fie >= 0");

            if (stoc < 0)
                throw new IllegalArgumentException("Stocul trebuie sa fie >= 0");

            this.nume = nume;
            this.pretVechi = pret;
            this.pretNou = pret;
            this.stoc = stoc;
            this.redus = false;
        }

        public String getNume() {
            return nume;
        }

        public double getPretVechi() {
            return pretVechi;
        }

        public double getPretNou() {
            return pretNou;
        }

        public int getStoc() {
            return stoc;
        }

        public boolean isRedus() {
            return redus;
        }

        @Override
        public String toString() {
            return String.format(Locale.US,
                    "%s, pret vechi: %.2f, pret nou: %.2f, stoc: %d%s",
                    nume, pretVechi, pretNou, stoc, redus ? " [REDUS]" : "");
        }
    }

    private final HashMap<String, Produs> produse = new HashMap<>();

    public void adaugaProdus(String cod, String name, double pret, int stoc) {
        if (cod == null || cod.trim().isEmpty()) {
            throw new IllegalArgumentException("Codul nu poate fi nul sau vid");
        }
        if (produse.containsKey(cod)) {
            throw new IllegalArgumentException("Codul exista deja: " + cod);
        }
        produse.put(cod, new Produs(name, pret, stoc));
    }

    /**
     * Applies a 15% discount to every product with stock below 50.
     * <p>
     * The discount is computed from the old price, so calling this
     * method twice does not discount a product twice.
     *
     * @param cod  the product code, must not be null or blank
     * @param stoc the stock, must be {@code >= 0}
     * @return the product that was added
     * @throws IllegalArgumentException if the code already exists
     * @see Produs
     * @since 1.0
     */
    public void aplicaReduceriStocMic() {
        for (Produs produs : produse.values()) {
            if (produs.stoc < 50) {
                produs.pretNou = BigDecimal.valueOf(produs.pretVechi).multiply(new BigDecimal("0.85"))
                        .setScale(2, RoundingMode.HALF_UP).doubleValue();
                produs.redus = true;
            }
        }
    }

    public void afiseazaInventar() {
        for (Map.Entry<String, Produs> produs : produse.entrySet()) {
            System.out.println(produs.getKey() + " -> " + produs.getValue());
        }
    }

    public Produs getProdus(String cod) {
        return produse.get(cod);
    }
}
