public class MyList {
    private Node head;
    private int size;

    public MyList() {
        head = new Node(null);
        size = 0;
    }

    //Adauga un obiect in lista
    public void add(Object data) {
        Node temp = new Node(data);
        Node current = head;
        while(current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(temp);
        size++;
    }

    public void add(Object data, int index) {
        Node temp = new Node(data);
        Node current = head;
        for(int i = 0; i < index && current.getNext() != null; i++) {
            current = current.getNext();
        }
        temp.setNext(current.getNext());
        current.setNext(temp);
        size++;
    }

    public Object get(int index) {
        if(index < 0 && index >= this.size) {
            return null;
        } else {
            Node current = head.getNext();
            for(int i = 0; i < index; i++) {
                if(current.getNext() == null) {
                    return null;
                }
                current = current.getNext();
            }
            return current.getData();
        }
    }

    public boolean remove(int index) {
        if(index < 0 || index >= size) {
            return false;
        }
        Node current = head;
        for(int i = 0; i < index; i++) {
            if(current.getNext() == null) {
                return false;
            }
            current = current.getNext();
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    public String toString() {
        Node current = head.getNext();
        String result = "";
        while(current != null) {
            result += "[" + current.getData() + "] ";
            current = current.getNext();
        }
        return result;
    }

    
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.next = null;
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.next = next;
            this.data = data;
        }

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }
}

class Graph extends MyList {
    private int n;
    private int[] vizitat;

    public Graph(int n) {
        super();
        this.n = n;
        this.vizitat = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            super.add(new MyList());
        }
    }

    public void add(int x, int y) {
        MyList list = (MyList) get(x);
        list.add(y);
    }

    public void dfs(int start) {
        MyList list = (MyList) get(start);
        System.out.print(start + " ");
        vizitat[start] = 1;
        if (list != null) {
            for (int k = 0; k < list.size(); k++) {
                int j = (Integer) list.get(k);
                if (vizitat[j] == 0) {
                    dfs(j);
                }
            }
        }
    }

    public String toString() {
        String result = "";
        for (int i = 1; i <= n; i++) {
            result += i + ": " + get(i) + "\n";
        }
        return result;
    }
}