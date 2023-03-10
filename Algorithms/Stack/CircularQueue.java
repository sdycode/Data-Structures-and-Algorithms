public class CircularQueue {

    private static final int DEFAULT_SIZE = 3;

    protected int[] data;
int size = 0;
int front =0;
    int end = 0;

    CircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CircularQueue(int size) {
        this.data = new int[size];
    }

    public boolean insert(int item) {
        if (isFull()) {
            return false;
        }
        data[end++] = item;
        end= end%data.length;
        size++;

        return true;
    }

    public int remove() throws Exception {
// we need to remove first item i.e data[0] as queue is FIFO
        if (isEmpty()) {
            throw new Exception("Queue is empty");
        }
        int removed = data[front++];
        front = front%data.length;
        size--;


        return removed;
    }

    public int front() throws Exception {
        if (isEmpty()) {
            throw new Exception("This is empty stack");
        }
        return data[front];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == data.length;
    }
}
