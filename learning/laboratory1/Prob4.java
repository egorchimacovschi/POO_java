public class Prob4{
    public static void main(String[] args){
        int length = args.length;

        if (length == 0){
            System.out.println("Nu s-au primit argumente");
        }else {
            for (int i = 0; i < length; i++) {
                System.out.print(args[i] + " " + i);
                System.out.println("");
            }
            System.out.println("");
        }
    }
}