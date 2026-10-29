import static java.lang.Math.*;
class Patrulater {
    public int latura1, latura2, latura3, latura4;
    public double unghi1, unghi2, unghi3, unghi4;

    public Patrulater() {
        this(0, 0, 0, 0);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4) {
        this.latura1 = latura1;
        this.latura2 = latura2;
        this.latura3 = latura3;
        this.latura4 = latura4;
    }

    public Patrulater(double unghi1, double unghi2, double unghi3, double unghi4) {
        this(0, 0, 0, 0, unghi1, unghi2, unghi3, unghi4);
    }

    public Patrulater(int latura1, int latura2, int latura3, int latura4,
                      double unghi1, double unghi2, double unghi3, double unghi4) {
        this(latura1, latura2, latura3, latura4);
        this.unghi1 = unghi1;
        this.unghi2 = unghi2;
        this.unghi3 = unghi3;
        this.unghi4 = unghi4;
    }

    public int perimetru() {
        int result;
        result = latura1 + latura2 + latura3 + latura4;
        return result;
    }
}

class Paralelogram extends Patrulater {
    public Paralelogram(int latura1, int latura2){
        super(latura1, latura2, latura1,  latura2, 90, 90, 90, 90);
    }

    public Paralelogram(int latura1, int latura2, double unghi1, double unghi2){
        super(latura1, latura2, latura1, latura2, unghi1, unghi2, unghi1, unghi2);
    }

    public double ariaParalelogram(){
        return latura1 * latura2 * sin(toRadians(unghi1));
    }
}

class Romb extends Paralelogram{
    public Romb(int latura){
        super(latura, latura);
    }

    public Romb(int latura, double unghi1, double unghi2){
        super(latura, latura, unghi1, unghi2);
    }

    public double ariaRomb(){
        double unghi = unghi1 > unghi2 ? unghi2 : unghi1;
        double d1 = 2 * latura1 * cos(toRadians(unghi / 2));
        double d2 = 2 * latura1 * sin(toRadians(unghi / 2));

        return (d1 * d2) / 2;
    }
}

class Dreptunghi extends Paralelogram{
    public Dreptunghi(int latura1, int latura2){
        super(latura1, latura2, 90, 90);
    }

    public double ariaDreptunghi(){
        return latura1 * latura2;
    }
}

class  Patrat extends Dreptunghi{
    public Patrat(int latura){
        super(latura, latura);
    }

    public double ariaPatrat(){
        return pow(latura1, 2);
    }
}

class Test {
    public static void main(String[] args) {
        Dreptunghi d = new Dreptunghi(5, 3);
        System.out.println(d.ariaDreptunghi());
        System.out.println(d.perimetru());

        Patrat p = new Patrat(4);
        System.out.println(p.ariaPatrat());
        System.out.println(p.perimetru());

        Romb r = new Romb(5, 30, 150);
        System.out.println(r.ariaRomb());
    }
}