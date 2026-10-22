class Fractie{
    int numarator;
    int numitor;

    public Fractie(int numarator, int numitor){
        if(numitor == 0){
            throw new IllegalArgumentException();
        }
        if (numitor < 0) {
            numarator = -numarator;
            numitor = -numitor;
        }
        int d = cmmdc(Math.abs(numarator), numitor);
        this.numarator = numarator / d;
        this.numitor = numitor / d;
    }

    public Fractie(){
        this(0, 1);
    }

    private static int cmmdc(int a, int b){
        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Fractie sumFractie(Fractie fractieNoua) {
        int num = this.numarator * fractieNoua.numitor + fractieNoua.numarator * this.numitor;
        int numi = this.numitor * fractieNoua.numitor;
        return new Fractie(num, numi);
    }

    @Override
    public String toString(){
        return numarator + "/" + numitor;
    }

    @Override
    public boolean equals(Object f){
        if(this == f){
            return true;
        }

        if(f == null || getClass() != f.getClass()){
            return false;
        }
        Fractie newF = (Fractie) f;
        return this.numarator == newF.numarator && this.numitor == newF.numitor;
    }
}

public class Problema1{
    public static void main(String[] args) {
        Fractie f1 = new Fractie(1, 2);
        Fractie f2 = new Fractie(1, 3);
        Fractie f3 = new Fractie(2, 4);
        Fractie f4 = new Fractie();

        System.out.println("f1 = " + f1);
        System.out.println("f2 = " + f2);
        System.out.println("f3 = " + f3);
        System.out.println("f4 (implicita) = " + f4);

        System.out.println("f1 + f2 = " + f1.sumFractie(f2));
        System.out.println("f1 + f3 = " + f1.sumFractie(f3));

        System.out.println("f1.equals(f3): " + f1.equals(f3));
        System.out.println("f1.equals(f2): " + f1.equals(f2));
        System.out.println("f1.equals(\"text\"): " + f1.equals("text"));
    }
}
