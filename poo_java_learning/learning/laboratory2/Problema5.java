
public class Problema5{
    public static void main(String[] args){
        String text = "Un terorist avea o bomba";
        String cuvinte[] = new String[2];
        cuvinte[0] = "terorist";
        cuvinte[1] = "bomba";
        Problema5 prb5 = new Problema5();
        String rezultat;
        rezultat = prb5.cenzurare(text, cuvinte);
        System.out.println(rezultat);
    }

    String cenzurare(final String text, String[] cuvinte) {
        String rezultat = text;
        boolean suspect = false;

        for (int i = 0; i < cuvinte.length; i++) {
            if (text.contains(cuvinte[i])) {
                suspect = true;
                rezultat = rezultat.replace(cuvinte[i], cenzureaza(cuvinte[i]));
            }
        }

        if (suspect) {
            System.out.println("Text suspect");
        } else {
            System.out.println("Nimic suspect");
        }
        return rezultat;
    }

    static String cenzureaza(String cuvant) {
        String stele = "";
        for (int i = 1; i < cuvant.length() - 1; i++) {
            stele = stele + "* ";
        }
        stele = stele.trim();   // removes the extra space at the end

        return cuvant.charAt(0) + stele + cuvant.charAt(cuvant.length() - 1);
    }
}