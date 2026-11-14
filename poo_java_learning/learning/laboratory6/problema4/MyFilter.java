import java.io.File;
import java.io.FilenameFilter;
import java.io.RandomAccessFile;
import java.util.Vector;

public class MyFilter implements FilenameFilter {

    private Vector<String> extensions;
    private Vector<String> words;

    private File dir;
    private File[] files;

    public MyFilter() {
        dir = new File(".");

        extensions = readFile("extension.in");
        words = readFile("words.in");

        files = dir.listFiles(this);
    }

    public Vector<String> readFile(String name) {
        Vector<String> result = new Vector<String>();
        RandomAccessFile file = null;

        try {
            file = new RandomAccessFile(name, "r");
            String linie;

            while ((linie = file.readLine()) != null) {
                linie = linie.trim();
                if (!linie.isEmpty()) {
                    result.add(linie);
                }
            }

        } catch (Exception e) {
            System.out.println("Eroare la deschiderea fisierului: " + name);
        } finally {
            if (file != null) {
                try {
                    file.close();
                } catch (Exception e) {
                    System.out.println("Eroare la inchidere: " + e.getMessage());
                }
            }
        }

        return result;
    }

    @Override
    public boolean accept(File dir, String name) {
        boolean extensieOk = false;

        for (String extension : extensions) {
            if (name.endsWith(extension)) {
                extensieOk = true;
                break;
            }
        }

        if (!extensieOk) {
            return false;
        }

        if (words.isEmpty()) {
            return true;
        }

        for (String word : words) {
            if (name.toLowerCase().contains(word.toLowerCase())) {
                return true;
            }
        }

        return false;
    }

    public File[] getFiles() {
        return files;
    }
}
