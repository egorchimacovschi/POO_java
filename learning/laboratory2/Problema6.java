import java.util.Vector;

public class Problema6 {
    public static void main(String[] args) {
        Vector v = new Vector();
        v.add(7);
        v.add(3.5f);
        v.add(true);
        v.add("abc");

        int nrInt = 0, nrFloat = 0, nrBoolean = 0, nrString = 0;

        for (int i = 0; i < v.size(); i++) {
            Object o = v.get(i);

            if (o instanceof Integer)
                nrInt++;
            else if (o instanceof Float)
                nrFloat++;
            else if (o instanceof Boolean)
                nrBoolean++;
            else if (o instanceof String)
                nrString++;
        }

        Vector<Integer> aparitii = new Vector<>();
        aparitii.add(nrInt);
        aparitii.add(nrFloat);
        aparitii.add(nrBoolean);
        aparitii.add(nrString);

        System.out.println("int:     " + aparitii.get(0));
        System.out.println("float:   " + aparitii.get(1));
        System.out.println("boolean: " + aparitii.get(2));
        System.out.println("String:  " + aparitii.get(3));
    }
}