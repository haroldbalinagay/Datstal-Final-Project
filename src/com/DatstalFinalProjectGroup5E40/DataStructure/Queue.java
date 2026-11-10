package com.DatstalFinalProjectGroup5E40.DataStructure;

public class Queue {
    private int[] queueArray;
    private int front;
    private int rear;
    private int capacity;
    private int size;
    //constructor
    public Queue(int capacity) {
        this.capacity = capacity;
        this.queueArray = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public void enqueue(int item) {
        if (isFull()) {
            IO.println("Queue Overflow! Cannot enqueue " + item);
            return;
        }
        rear = (rear + 1) % capacity;
        queueArray[rear] = item;
        size++;
    }
    public int dequeue() {
        if (isEmpty()) {
            IO.println("Queue Underflow! Queue is empty.");
            return -1;
        }
        int item = queueArray[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }
    public int peek() {
        if (isEmpty()) {
            IO.println("Queue is empty.");
            return -1;
        }
        return queueArray[front];
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Queue q = new Queue(3);
        //initilizes queue
        IO.println("Initializing queue with capacity 3.");
        IO.println("Is queue empty? (expected: true): " + q.isEmpty());
        IO.println("Is queue full? (expected: false): " + q.isFull());
        IO.println("Initial size (expected: 0): " + q.size());
        //test enqueue
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        IO.println("Enqueued 10, 20, 30");
        IO.println("Is queue full? (expected: true): " + q.isFull());
        IO.println("Current size (expected: 3): " + q.size());
        IO.println("Peek front element (expected: 10): " + q.peek());
        //test overflow
        IO.println("Attempting to enqueue 40 into a full queue");
        q.enqueue(40); //trigger overlow msg
        //test dequeue
        IO.println("Dequeued (expected: 10): " + q.dequeue());
        IO.println("Dequeued (expected: 20): " + q.dequeue());
        IO.println("Current size after 2 dequeues (expected: 1): " + q.size());
        IO.println("New peek front (expected: 30): " + q.peek());
        IO.println("Enqueuing 40 and 50 to test circular wrap-around");
        q.enqueue(40);
        q.enqueue(50);
        IO.println("Is queue full now? (expected: true): " + q.isFull());
        IO.println("Peek front (expected: 30): " + q.peek());
        IO.println("Dequeued (expected: 30): " + q.dequeue());
        IO.println("Dequeued (expected: 40): " + q.dequeue());
        IO.println("Dequeued (expected: 50): " + q.dequeue());
        IO.println("Is queue empty? (expected: true): " + q.isEmpty());
        IO.println("Final size (expected: 0): " + q.size());
        IO.println("Attempting dequeue on an already empty queue:");
        q.dequeue(); // trigger underflow msg
    }
}