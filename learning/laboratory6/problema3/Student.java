import java.util.Vector;

public class Student implements Persoana {
    private String nume;

    private Vector<Double> mediile;

    public Student() {
        nume = new String("palcehoder");
        mediile = new Vector<>();
    }

    public Student(String nume, double... varMediile) {
        this.nume = nume;
        mediile = new Vector<>();

        for (double medie : varMediile) {
            mediile.add(medie);
        }
    }

    @Override
    public double calculMedieGenerala() {
        double sum = 0;

        for (double medie : mediile) {
            sum += medie;
        }

        return (double) sum / mediile.size();
    }

    @Override
    public String getNume() {
        return nume;
    }

    @Override
    public void setNume(String name) {
        this.nume = name;
    }

    @Override
    public void addMedie(double medie) {
        mediile.add(medie);
    }

    @Override
    public int compareTo(Persoana o) {
        int cmpReturnValue = this.nume.compareTo(o.getNume());

        if (cmpReturnValue != 0) {
            return cmpReturnValue;
        }

        cmpReturnValue = (this.calculMedieGenerala() >= o.calculMedieGenerala()) ? -1 : 1;

        return cmpReturnValue;
    }

    @Override
    public String toString() {
        return nume + " (media: " + calculMedieGenerala() + ")";
    }
}
