public class CustomStack {

    private static final int DEFAULT_SIZE = 3;

    protected int[] data;

    int ptr = -1;

    CustomStack() {
        this(DEFAULT_SIZE);
    }

    public CustomStack(int size) {
        this.data = new int[size];
    }

    public boolean push(int item) throws Exception {
        if (isFull()) {
            throw  new Exception("Stack is full");
        }
        ptr++;
        data[ptr] = item;
        return true;
    }

    public int pop() throws  Exception {
        if(isEmpty()){
            throw new  Exception("Cant pop from empty stack");
        }
        int removed = data[ptr];
        ptr--;
        return  removed;
    }
    public  int peek()throws Exception{
        if(isEmpty()){
            throw new Exception("This is empty stack");
        }
        return  data[ptr];
    }

    public boolean isEmpty() {
        return ptr == -1;
    }

    public boolean isFull() {
        return ptr >= data.length - 1;
    }

}
