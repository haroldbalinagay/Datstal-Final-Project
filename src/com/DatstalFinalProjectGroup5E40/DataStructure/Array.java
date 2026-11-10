
package com.DatstalFinalProjectGroup5E40.DataStructure;

import java.util.Scanner;

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

    public void add(String place) {
        if (isFull()) {
            System.out.println("Array is full!");
            return;
        }

        places[size] = place;
        size++;
    }

    public void display() {
        System.out.println("\nCampus Locations:");

        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + places[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("CAMPUS MAP FINDER");

        int capacity;

        do {
            System.out.print("Enter array capacity: ");

            while (!sc.hasNextInt()) {
                System.out.print("Enter a valid number: ");
                sc.next();
            }

            capacity = sc.nextInt();

            if (capacity <= 0) {
                System.out.println("Capacity must be positive.");
            }

        } while (capacity <= 0);

        sc.nextLine();

        Array campus = new Array(capacity);

        for (int i = 0; i < capacity; i++) {
            System.out.print("Enter location " + (i + 1) + ": ");
            String place = sc.nextLine();
            campus.add(place);
        }

        campus.display();

        System.out.println("\nCapacity: " + campus.capacity);
        System.out.println("Size: " + campus.size());
        System.out.println("Is Empty: " + campus.isEmpty());
        System.out.println("Is Full: " + campus.isFull());

        sc.close();
    }
}
