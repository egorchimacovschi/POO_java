import  java.lang.Exception;

interface Stack {
    void push(Object item) throws  StackException;
    void pop() throws StackException;
    Object peek() throws StackException;
    boolean empty();
    String toString();
}

class StackException extends Exception {
    public StackException(){
        super();
    }

    public  StackException(String message){
        super(message);
    }
}

class StackVector implements Stack{
    private Object items[];
    private int n = 0;


    public StackVector(){
        this(100);
    }

    public StackVector(int max){
        items = new Object[max];
    }

    @Override
    public boolean empty(){
        return n == 0;
    }

    @Override
    public void push(Object item) throws StackException{
        if (n == items.length) throw new StackException("Stiva este plina!");
        items[n++] = item;
    }

    @Override
    public void pop() throws StackException{
        if (empty()) throw new StackException("Stiva e vida!");
        items[--n] = null;
    }

    @Override
    public Object peek() throws StackException {
        if (empty()) throw new StackException("Stiva este vida!");
        return items[n - 1];
    }

     @Override
     public String toString(){
        String string = "";

        for (int i = n - 1; i >= 0; i--)
            string += items[i] + " ";

        return string;
     }
}

class StackList implements Stack{
    class Node{
        Object item;
        Node link;
        Node (Object item, Node link) {
            this.item = item;
            this.link = link;
        }
    }

    private Node top = null;

    @Override
    public boolean empty(){
        return top == null;
    }

    @Override
    public void push(Object item) {
        Node node = new Node(item, top);
        top = node;
    }

    @Override
    public void pop() throws StackException{
        if (empty()) throw new StackException("Stiva este vida!");
        top = top.link;
    }

    @Override
    public Object peek() throws StackException {
        if (empty()) throw new StackException("Stiva este vida!");
        return top.item;
    }

    @Override
    public String toString(){
        String string = "";
        Node node = top;

        while(node != null){
            string += node.item + " ";
            node = node.link;
        }

        return string;
    }
}

public class TestStiva {
    public static void main ( String args []){
        try {
            StackVector s1 = new StackVector();
            s1.push ("a");
            s1.push ("b");
            System.out.println("Stiva contine:" + s1);
            Stack s2 = new StackList();
            s2.push ( new Integer (1));
            s2.push ( new Double (3.14) );
            System.out.println("Stiva contine:" + s2);
        } catch ( StackException e) {
            System.err.println("Eroare stiva!");
            e.printStackTrace (); }
    }
}