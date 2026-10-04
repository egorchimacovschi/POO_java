public class Printer{
    public void printInt(int x) {
        System.out.println(x);
    }

    public static void main(String[] args) {
        Printer obiect = new Printer();

        obiect.printInt(12);
    }
}