public class Problema2{
    static public void main(String[] args){
        Magazin m = new Magazin("Mega",
                new Produs("Paine", 3.5, 10),
                new Produs("Lapte", 7.0, 5),
                new Produs("Ou", 1.2, 30));

        System.out.println(m);
        System.out.println("Total magazin: " + m.getTotalMagazin());
    }
}

class Produs{
    String nume = new String();
    double pret;
    int cantitate;

    public Produs(String nume, double pret, int cantitate){
        this.nume = nume;
        this.pret = pret;
        this.cantitate = cantitate;
    }

    public double getTotalProdus(){
        return pret*cantitate;
    }

    @Override
    public String toString(){
        return "Produs " + nume + " " + pret + " " + cantitate;
    }
}

class Magazin{
    String nume = new String();
    Produs[] produs = new Produs[3];

    public Magazin(String nume, Produs p1, Produs p2, Produs p3){
        this.nume = nume;
        produs[0] = p1;
        produs[1] = p2;
        produs[2] = p3;
    }

    @Override
    public String toString(){
        return "Magazin" + produs[0].toString() + '\n' + produs[1].toString() + '\n' + produs[2].toString();
    }

    public double getTotalMagazin(){
        return produs[0].getTotalProdus() + produs[1].getTotalProdus() + produs[2].getTotalProdus();
    }

}