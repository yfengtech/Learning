package queue;

public class MyCircularQueue {

    private final int[] arr;

    private int head = -1;
    private int tail = -1;

    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        } else {
            if (isEmpty()) {
                head = forward(head);
            }
            tail = forward(tail);
            arr[tail] = value;
            return true;
        }
    }

    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        } else {
            if (head == tail) {
                // 最后一个出队
                head = -1;
                tail = -1;
            } else {
                head = forward(head);
            }
            return true;
        }
    }

    public int Front() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[head];
        }
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        } else {
            return arr[tail];
        }
    }

    public boolean isEmpty() {
        return head < 0 && tail < 0;
    }

    public boolean isFull() {
        if (isEmpty())
            return false;

        // 如果队列size=1，head=tail就满
        if (head == tail && arr.length == 1) {
            return true;
        }

        // tail右移和head重合，此时为满
        if (head > tail) {
            return head == tail + 1;
        } else if (head < tail) {
            return head == 0 && tail == arr.length - 1;
        }
        return false;
    }

    private int forward(int index) {
        if (index < arr.length - 1) {
            return index + 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);
        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);
        q.enQueue(4);
        q.Rear();
        q.isFull();
        q.deQueue();
        q.enQueue(4);
        q.Rear();
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */