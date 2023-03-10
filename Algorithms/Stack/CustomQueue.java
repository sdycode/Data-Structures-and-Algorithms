public class CustomQueue {

    private static final int DEFAULT_SIZE = 3;

    protected int[] data;

    int end = 0;

    CustomQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end] = item;
        end++;
        return true;
    }

    public int remove() throws Exception {
// we need to remove first item i.e data[0] as queue is FIFO
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[0];
//        we need to shift all elements to left
        for (int i = 1; i < end; i++) {
            data[i - 1] = data[i];
        }
        end--;
        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("This is empty stack");
        }
        return data[0];
    }

    public boolean isEmpty() {
        return end == 0;
    }

    public boolean isFull() {
        return end == data.length ;
    }

}
