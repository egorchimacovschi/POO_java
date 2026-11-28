public class Test {
    public static void main(String[] args) {

        SortedVector<Pair> byFirst = new SortedVector<>(new Comp1());
        SortedVector<Pair> bySecond = new SortedVector<>(new Comp2());

        Pair p1 = new Pair("Banana", 3);
        Pair p2 = new Pair("Apple", 5);
        Pair p3 = new Pair("Cherry", 1);

        byFirst.add(p1);
        byFirst.add(p2);
        byFirst.add(p3);

        bySecond.add(p1);
        bySecond.add(p2);
        bySecond.add(p3);

        System.out.println("Sortat dupa primul element: " + byFirst);
        System.out.println("Sortat dupa al doilea element: " + bySecond);
    }
}
