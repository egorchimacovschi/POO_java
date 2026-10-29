import java.util.Collections;
import java.util.Vector;
import java.util.EmptyStackException;

class Array {
    //Vectorul in care se vor retine elementele
    private Vector vector;

    //Constructor clasei
    public Array() {
        //Instantierea vectorului cu elemente
        vector = new Vector();
    }

    //Metoda care adauga un element in vector, folosind pozitia curenta
    public void addElement(Integer x) {
        vector.add(x);
    }

    //Metoda care adauga un element in vector, tinand cont de pozitia indicata
    public void addElement(Integer x, int poz) {
        if(poz >= 0 && poz <= vector.size()) {
            vector.add(poz, x);
        }
    }

    //Metoda care returneaza elementul aflat in vector la pozitia indicata
    public int get(int poz) {
        int result;
        if(poz >= 0 && poz < vector.size()) {
            result = (int) vector.get(poz);
            return result;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    //Metoda ce intoarce numarul de elemente din vector
    public int getSize() {
        return vector.size();
    }

    //Metoda pentru stergerea unui element din vector
    public boolean remove(Integer x) {
        return vector.remove(x);
    }

    //Metoda pentru stergerea elementului de pe pozitia pos din vector
    public Integer remove(int pos) {
        return (Integer) vector.remove(pos);
    }

    //Metoda uzitata pentru afisarea unui obiect de tip Array
    public String toString() {
        String result = "{";
        for(int i = 0; i < vector.size(); i++) {
            result += get(i) + ", ";
        }
        result += "}";
        return result;
    }

    public void sort() {
        Collections.sort(vector);
    }
}

class SortedArray extends Array{
    public SortedArray(){
        super();
    }

    @Override
    public void addElement(Integer x) {
        int i = 0;
        while (i < getSize() && get(i) <= x) {
            i++;
        }
        super.addElement(x, i);
    }

    @Override
    public void addElement(Integer x, int poz) {
        addElement(x);
    }
}

class MyStack {
    private Array array;

    public MyStack(){
        array = new Array();
    }

    public void push(int x){
        array.addElement(x);
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        return array.get(array.getSize() - 1);
    }
…/learning/laboratory4 main ? ✗ git status
    On branch main
    Your branch is up to date with 'origin/main'.

    Changes to be committed:
            (use "git restore --staged <file>..." to unstage)
            new file:   Array.class
        new file:   Dreptunghi.class
        new file:   MyStack.class
        new file:   Paralelogram.class
        new file:   Patrat.class
        new file:   Patrulater.class
        new file:   Problema2.class
        new file:   Romb.class
        new file:   SortedArray.class
        new file:   Test.class

    Changes not staged for commit:
            (use "git add/rm <file>..." to update what will be committed)
            (use "git restore <file>..." to discard changes in working directory)
    deleted:    Array.class
    deleted:    Dreptunghi.class
    deleted:    MyStack.class
    deleted:    Paralelogram.class
    deleted:    Patrat.class
    deleted:    Patrulater.class
    deleted:    Problema2.class
    deleted:    Romb.class
    deleted:    SortedArray.class
    deleted:    Test.class

    Untracked files:
            (use "git add <fi…/learning/laboratory4 main ? ✗ git status
    On branch main
    Your branch is up to date with 'origin/main'.

    Changes to be committed:
            (use "git restore --staged <file>..." to unstage)
            new file:   Array.class
        new file:   Dreptunghi.class
        new file:   MyStack.class
        new file:   Paralelogram.class
        new file:   Patrat.class
        new file:   Patrulater.class
        new file:   Problema2.class
        new file:   Romb.class
        new file:   SortedArray.class
        new file:   Test.class

    Changes not staged for commit:
            (use "git add/rm <file>..." to update what will be committed)
            (use "git restore <file>..." to discard changes in working directory)
    deleted:    Array.class
    deleted:    Dreptunghi.class
    deleted:    MyStack.class
    deleted:    Paralelogram.class
    deleted:    Patrat.class
    deleted:    Patrulater.class
    deleted:    Problema2.class
    deleted:    Romb.class
    deleted:    SortedArray.class
    deleted:    Test.class

    Untracked files:
            (use "git add <fi…/learning/laboratory4 main ? ❯ git status
    On branch main
    Your branch is up to date with 'origin/main'.

    Untracked files:
            (use "git add <file>..." to include in what will be committed)
            ./

    nothing added to commit but untracked files present (use "git add" to track)

…/learning/laboratory4 main ? ❯ le>..." to include in what will be committed)
    Makefile       Problema1.java Problema2.java


…/learning/laboratory4 main ? ❯ le>..." to include in what will be committed)
    Makefile       Problema1.java Problema2.java


…/learning/laboratory4 main ? ❯
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array.remove(array.getSize() - 1);
    }

    public boolean isEmpty(){
        return array.getSize() == 0;
    }

    public int size(){
        return array.getSize();
    }

    @Override
    public String toString(){
        return array.toString();
    }
}

public class Problema2 {
    public static void main(String[] args) {
        SortedArray sa = new SortedArray();
        sa.addElement(5);
        sa.addElement(1);
        sa.addElement(8);
        sa.addElement(3);
        sa.addElement(10, 0);
        System.out.println(sa);
        sa.remove(Integer.valueOf(3));
        System.out.println(sa);

        MyStack st = new MyStack();
        st.push(10);
        st.push(20);
        st.push(30);
        System.out.println(st);
        System.out.println(st.pop());
        System.out.println(st.peek());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.isEmpty());

        try {
            st.pop();
        } catch (java.util.EmptyStackException e) {
            System.out.println("Stiva este goala");
        }
    }
}