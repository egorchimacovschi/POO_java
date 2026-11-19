import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Problema4 {
    private static final String DELIMITERS = "[^\\p{L}]+";

    public static void main(String[] args) throws IOException {
        String file = args.length > 0 ? args[0] : "test4.txt";
        TreeMap<String, LinkedList<Integer>> dict = new TreeMap<String, LinkedList<Integer>>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(file), StandardCharsets.UTF_8)) {
            String line;
            int lineNo = 0;
            while ((line = br.readLine()) != null) {
                lineNo++;
                for (String w : line.split(DELIMITERS)) {
                    if (w.isEmpty()) {
                        continue;
                    }
                    LinkedList<Integer> lines = dict.get(w);
                    if (lines == null) {
                        lines = new LinkedList<Integer>();
                        dict.put(w, lines);
                    }
                    lines.add(lineNo);
                }
            }
        }

        Iterator<Map.Entry<String, LinkedList<Integer>>> it = dict.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, LinkedList<Integer>> e = it.next();
            System.out.println(e.getKey());
            StringBuilder sb = new StringBuilder();
            for (Integer n : e.getValue()) {
                if (sb.length() > 0) {
                    sb.append(' ');
                }
                sb.append(n);
            }
            System.out.println(sb);
            System.out.println("Total: " + e.getValue().size());
            System.out.println();
        }
    }
}
