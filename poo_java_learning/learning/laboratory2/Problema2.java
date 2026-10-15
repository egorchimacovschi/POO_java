import java.util.StringTokenizer;

public class Problema2 {
    public static void main(String[] args) {
        String sir = args[0];   // text
        String cuvant = args[1];
        int count = 0; // pattern
        StringTokenizer st = new StringTokenizer(sir, ":,.-? ");
        while (st.hasMoreTokens()) {
            if(st.nextToken().equals(cuvant)){
                count += 1;
            }
        }
        System.out.println(count);
    }
}