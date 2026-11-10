package com.DatstalFinalProjectGroup5E40;

import com.DatstalFinalProjectGroup5E40.datastructure.Graph;
import com.DatstalFinalProjectGroup5E40.algorithms.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Graph graph = new Graph();
        boolean loaded = false;
        boolean run = true;

        while (run) {
            System.out.println();
            System.out.println("CAMPUS MAP FINDER");
            System.out.println("1. Load the map file");
            System.out.println("2. Show all places in A-to-Z order");
            System.out.println("3. Find a path between 2 places");
            System.out.println("4. Quit");
            System.out.print("Choose (1-4): ");

            String choice = input.nextLine().trim();

            switch (choice) {
                case "1":
                    if (graph.loadFromFile("src/com/DatstalFinalProjectGroup5E40/resources/map.txt")) {
                        loaded = true;
                        System.out.println("\nLoaded " + graph.getPlaceCount() + " places.");
                        graph.printGraph();
                    } else {
                        System.out.println("Error: file not found");
                    }
                    break;

                case "2":
                    if (!loaded) {
                        System.out.println("Load the map file first (option 1).");
                        break;
                    }
                    int n = graph.getPlaceCount();
                    // Copy the names so the graph's original array stays in its original order
                    String[] sorted = new String[n];
                    for (int i = 0; i < n; i++) {
                        sorted[i] = graph.getPlaceName(i);
                    }

                    InsertionSort.sort(sorted);   // sort the copy A-to-Z

                    System.out.println("Places (A-to-Z):");
                    for (int i = 0; i < n; i++) {
                        System.out.println((i + 1) + ". " + sorted[i]);
                    }
                    break;

                case "3":
                    if (!loaded) {
                        System.out.println("Load the map file first (option 1).");
                        break;
                    }
                    IO.print("Enter starting place: ");
                    String start = input.nextLine().trim();
                    IO.print("Enter destination place: ");
                    String dest = input.nextLine().trim();
                    com.DatstalFinalProjectGroup5E40.algorithms.BFS.findPath(graph, start, dest);
                    break;

                case "4":
                    System.out.println("Exiting program");
                    run = false;
                    break;

                default:
                    System.out.println("Invalid choice. Enter a number from 1 to 4.");
            }
        }
        input.close();
    }
}