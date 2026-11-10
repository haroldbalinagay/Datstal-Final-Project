
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

    public void insert(int position, String place) {
        if (isFull()) {
            System.out.println("Array is full!");
            return;
        }

        if (position < 1 || position > size + 1) {
            System.out.println("Invalid position!");
            return;
        }

        for (int i = size; i >= position; i--) {
            places[i] = places[i - 1];
        }

        places[position - 1] = place;
        size++;

        System.out.println("Location inserted successfully!");
    }

    public void delete(int position) {
        if (isEmpty()) {
            System.out.println("Array is empty!");
            return;
        }

        if (position < 1 || position > size) {
            System.out.println("Invalid position!");
            return;
        }

        for (int i = position - 1; i < size - 1; i++) {
            places[i] = places[i + 1];
        }

        places[size - 1] = null;
        size--;

        System.out.println("Location deleted successfully!");
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        System.out.println("\nCampus Locations:");

        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + places[i]);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("CAMPUS MAP FINDER");
        System.out.print("Enter array capacity: ");

        int capacity;

        while (true) {
            if (sc.hasNextInt()) {
                capacity = sc.nextInt();

                if (capacity > 0) {
                    break;
                }
            } else {
                sc.next();
            }

            System.out.print("Enter a positive number: ");
        }

        Array campus = new Array(capacity);
        int choice = 0;

        do {
            System.out.println("\narray menu");
            System.out.println("1. Insert Location");
            System.out.println("2. Delete Location");
            System.out.println("3. Display Locations");
            System.out.println("4. Array Status");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid choice!");
                sc.next();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    if (campus.isFull()) {
                        System.out.println("Array is full!");
                        break;
                    }

                    System.out.print("Enter location name: ");
                    String place = sc.nextLine();

                    System.out.print("Enter position: ");

                    if (sc.hasNextInt()) {
                        int position = sc.nextInt();
                        campus.insert(position, place);
                    } else {
                        System.out.println("Invalid position!");
                        sc.next();
                    }
                    break;

                case 2:
                    if (campus.isEmpty()) {
                        System.out.println("Array is empty!");
                        break;
                    }

                    campus.display();
                    System.out.print("Enter position to delete: ");

                    if (sc.hasNextInt()) {
                        int position = sc.nextInt();
                        campus.delete(position);
                    } else {
                        System.out.println("Invalid position!");
                        sc.next();
                    }
                    break;

                case 3:
                    campus.display();
                    break;

                case 4:
                    System.out.println("Capacity: " + campus.capacity);
                    System.out.println("Size: " + campus.size());
                    System.out.println("Is Empty: " + campus.isEmpty());
                    System.out.println("Is Full: " + campus.isFull());
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}