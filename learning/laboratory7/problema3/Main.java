import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    private static final String DELIMITERS = "[^\\p{L}]+";

    public static void main(String[] args) throws IOException {
        String file = args.length > 0 ? args[0] : "test1.txt";
        String text = Files.readString(Paths.get(file), StandardCharsets.UTF_8);

        SListSet words = new SListSet();
        for (String w : text.split(DELIMITERS)) {
            if (!w.isEmpty()) {
                words.add(w);
            }
        }

        System.out.println("Crescator (" + words.size() + " cuvinte distincte):");
        for (Object w : words) {
            System.out.println(w);
        }

        System.out.println();
        System.out.println("Descrescator:");
        for (Object w : words.reversed()) {
            System.out.println(w);
        }
    }
}
