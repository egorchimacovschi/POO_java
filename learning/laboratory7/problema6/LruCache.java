import java.io.IOException;
import java.util.LinkedHashMap;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.util.Map;

@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
public class LruCache extends LinkedHashMap {
    private final int capacity;

    public LruCache(int capacity) {
        super(16, 0.75f, true);

        if (capacity <= 0)
            throw new IllegalArgumentException("Capacitatea trebuie sa fie strict pozitiva " + capacity);
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public Object put(Object key, Object value) {
        if (key == null)
            throw new NullPointerException("Cheia nu poate fi nula");

        return super.put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > capacity;
    }

    public static LruCache runOps(String opsFile, int capacity) throws IOException {
        LruCache cache = new LruCache(capacity);
        Path path = Paths.get(opsFile.trim());
        try (Scanner sc = new Scanner(path)) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine().trim();
                if (line.isEmpty() || line.startsWith("#"))
                    continue;

                String[] parts = line.split("\\s+");
                String op = parts[0].toUpperCase();
                if (op.equals("PUT") && parts.length == 3) {
                    cache.put(parts[1], parts[2]);
                } else if (op.equals("GET") && parts.length == 2) {
                    Object value = cache.get(parts[1]);
                    System.out.println(value == null ? "NULL" : value);
                }
            }
        }

        return cache;
    }

    public static void printCache(LruCache cache) {
        for (Object o : cache.entrySet()) {
            Map.Entry entry = (Map.Entry) o;
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java Main <capacity> <file-path>");
            System.exit(1);
        }

        int capacity;
        try {
            capacity = Integer.parseInt(args[0].trim());
        } catch (NumberFormatException e) {
            System.err.println("Error: capacity must be an integer, got '" + args[0] + "'");
            System.exit(1);
            return;
        }
        if (capacity <= 0) {
            System.err.println("Error: capacity must be positive, got " + capacity);
            System.exit(1);
        }

        Path path;
        try {
            path = Paths.get(args[1].trim());
        } catch (InvalidPathException e) {
            System.err.println("Error: invalid path '" + args[1] + "': " + e.getReason());
            System.exit(1);
            return;
        }
        if (!Files.isRegularFile(path)) {
            System.err.println("Error: not an existing file: " + path.toAbsolutePath());
            System.exit(2);
        }
        if (!Files.isReadable(path)) {
            System.err.println("Error: file is not readable: " + path.toAbsolutePath());
            System.exit(2);
        }
        LruCache cache;
        try {
            cache = runOps(path.toString(), capacity);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            System.exit(3);
            return;
        }

        System.out.println("---");
        printCache(cache);
    }
}
