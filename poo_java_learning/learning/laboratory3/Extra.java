public enum TipProdus {
    ALIMENTAR, ELECTRONIC, VESTIMENTAR, ALTUL
}

public record Produs(String nume, double pret, TipProdus tip){
    public void descriere(){
        System.out.println("Produs: " + "Nume=" + this.nume + " ,Tip=" + this.tip + ", Pret=" + this.pret);
    }
}

static public void main(String[] args){
    Produs p1 = new Produs("banana", 6.00, TipProdus.ALIMENTAR);
    Produs p2 = new Produs("Iphone", 6999.99, TipProdus.ELECTRONIC);
    Produs p3 = new Produs("Tricou", 100.00, TipProdus.VESTIMENTAR);

    System.out.println(p1.nume + " " + p1.pret + " " + p1.tip + '\n');
    System.out.println(p2.nume + " " + p2.pret + " " + p2.tip + '\n');
    System.out.println(p3.nume + " " + p3.pret + " " + p3.tip + '\n');

    p1.descriere();
}