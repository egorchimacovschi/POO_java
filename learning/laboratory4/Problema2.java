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