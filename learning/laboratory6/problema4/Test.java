import java.io.File;

public class Test {
    public static void main(String[] args) {
        MyFilter filtru = new MyFilter();
        File[] rezultate = filtru.getFiles();

        if (rezultate == null) {
            System.out.println("Niciun fisier gasit sau director invalid.");
            return;
        }

        for (File f : rezultate) {
            System.out.println(f.getName());
        }
    }
}
