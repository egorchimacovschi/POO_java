import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Comparator;

public class Problema1 {
    public Problema1() {

    }

    public static void main(String[] args) {
        String filePath = "test1.txt";
        Problema1 test = new Problema1();

        TreeSet<String> words = test.printWords(filePath);
        test.printLine();
        test.printWordsComparator(words);
    }

    public TreeSet<String> printWords(String fileName) {

        String line;
        int lineNumber = 1;
        String delim = " \t,.;:!?{}[]()-_+=\"";
        TreeSet<String> words = new TreeSet<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            while ((line = br.readLine()) != null) {
                System.out.println(lineNumber + ": " + line);
                lineNumber++;

                StringTokenizer st = new StringTokenizer(line, delim);
                while (st.hasMoreTokens()) {
                    words.add(st.nextToken().toLowerCase());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        for (String word : words) {
            System.out.println(word);
        }

        return words;
    }

    public TreeSet<String> printWordsComparator(TreeSet<String> asc) {
        TreeSet<String> reverseWords = new TreeSet<>(Comparator.reverseOrder());

        for (String word : asc) {
            reverseWords.add(word);
        }

        for (String word : reverseWords) {
            System.out.println(word);
        }

        return reverseWords;
    }

    public void printLine() {
        System.out.println("-------------------------------------------------");
    }
}
