import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        File dir = new File(args.length > 0 ? args[0] : ".");
        File[] files = dir.listFiles();
        if (files == null) {
            System.err.println("Nu pot citi directorul: " + dir.getPath());
            return;
        }

        HashMap<String, Integer> dict = new HashMap<String, Integer>();
        for (File f : files) {
            if (f.isFile()) {
                long bytes = f.length();
                dict.put(f.getName(), (int) ((bytes + 1023) / 1024));
            }
        }

        TreeMap<String, Integer> sorted = new TreeMap<String, Integer>(dict);
        System.out.println("Ordine alfabetica:");
        for (Map.Entry<String, Integer> e : sorted.entrySet()) {
            System.out.println(e.getKey() + " - " + e.getValue() + " KiB");
        }

        List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String, Integer>>(dict.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                int c = b.getValue().compareTo(a.getValue());
                return c != 0 ? c : a.getKey().compareTo(b.getKey());
            }
        });

        System.out.println();
        System.out.println("Ordine descrescatoare dupa dimensiune:");
        for (Map.Entry<String, Integer> e : list) {
            System.out.println(e.getKey() + " - " + e.getValue() + " KiB");
        }
    }
}
