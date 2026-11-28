class MyQueue{
    MyArray array;
    int inf;
    int firstIndex;
    int lastIndex;
    int lenght;

    public  MyQueue(){
        array = new MyArray();
        inf = 9500;
        firstIndex = 0;
        lastIndex = 0;
        lenght = 0;
    }

    public int getSize(){
        return this.lenght;
    }

    void enqueue(int value){
        array.set(lastIndex, value);
        lenght += 1;
        lastIndex++;
    }

    int dequeue(){
        if(this.lenght == 0){
            return 0;
        }

        int retValue = this.array.get(this.firstIndex);
        firstIndex++;
        lenght--;

        return  retValue;
    }

    boolean isEmpty(){
        return this.lenght == 0;
    }

    @Override
    public String toString(){
        String rezult = "";
        for(int i = 0; i < this.lenght; i++){
            rezult += array.get(this.firstIndex + i) + " ";
        }
        return rezult;
    }
}

class MyArray {
    private int v[];
    private int size;

    public MyArray() {
        v = new int[100];
    }

    public MyArray(int length) {
        size = 0;
        v = new int[length];
    }

    public int get(int poz) {
        if(poz < size) {
            return v[poz];
        } else {
            return -1;
        }
    }

    public void set(int pos, int value) {
        v[pos] = value;
        size++;
    }

    public int getSize() {
        return size;
    }
}


class Test {
    public static void main(String args[]) {
        MyQueue queue = new MyQueue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(10);
        queue.enqueue(-1);
        queue.enqueue(2);
        System.out.println(queue);
        System.out.println(queue.dequeue());
        System.out.println(queue.getSize());
        System.out.println(queue);
        queue.enqueue(9);
        queue.enqueue(queue.dequeue());
        queue.enqueue(11);
        queue.enqueue(22);
        System.out.println(queue);
        while(!queue.isEmpty()) {
            System.out.print(queue.dequeue() + " ");
        }
        System.out.println("");
        System.out.println(queue);
    }
}
