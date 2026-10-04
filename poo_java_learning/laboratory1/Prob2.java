public class Prob2{
    public void printInt(int numar){
        System.out.println(numar);
    }
    public static void main(String[] args){
        Prob2 obiect = new Prob2();

        obiect.printInt(42);
        obiect.printInt(7 + 5);
        obiect.printInt(3 * 10);
    }
}