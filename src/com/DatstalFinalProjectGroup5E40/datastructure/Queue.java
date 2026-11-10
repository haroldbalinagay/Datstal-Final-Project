package com.DatstalFinalProjectGroup5E40.datastructure;

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
}