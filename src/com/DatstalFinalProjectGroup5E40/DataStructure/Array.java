package com.DatstalFinalProjectGroup5E40.DataStructure;

public class Array {

    private String[] places;
    private int capacity;
    private int size;

    public Array(int capacity) {
        this.capacity = capacity;
        this.places = new String[capacity];
        this.size = 0;
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