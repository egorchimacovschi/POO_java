public class Problema1b {
    public static void main(String[] args) {
        String s1 = "sir1 si cu sir2 fac un sir3";
        String s2 = "si";
        int count = 0;
        int index = 0;

        while (!s2.isEmpty() && (index = s1.indexOf(s2, index)) != -1) {
            count++;
            index += s2.length();
        }

        System.out.println(count);
    }
}