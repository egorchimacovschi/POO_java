public class Problema1 {
    public static void main(String[] args) {
        String s1 = args[0];   // text
        String s2 = args[1];   // pattern
        int count = 0;
        for (int i = 0; i + s2.length() <= s1.length(); i++) {
            if (s1.substring(i, i + s2.length()).equals(s2)) {
                count += 1;
            }
        }
        System.out.println(count);
    }
}