package com.DatstalFinalProjectGroup5E40.datastructure;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Graph {

    public static final int MAX_PLACES = 100;

    private String[] places;
    private boolean[][] adj;
    private int placeCount;

    public Graph() {
        places = new String[MAX_PLACES];
        adj = new boolean[MAX_PLACES][MAX_PLACES];
        placeCount = 0;
    }

    public int getPlaceCount() {
        return placeCount;
    }

    public String getPlaceName(int index) {
        if (index < 0 || index >= placeCount) {
            return null;
        }
        return places[index];
    }

    public boolean isConnected(int i, int j) {
        if (i < 0 || j < 0 || i >= placeCount || j >= placeCount) {
            return false;
        }
        return adj[i][j];
    }

    public int findPlace(String name) {
        for (int i = 0; i < placeCount; i++) {
            if (places[i].equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    //methods for building graph
    public int addPlace(String name) {
        int existing = findPlace(name);
        if (existing != -1) {
            return existing;
        }
        if (placeCount >= MAX_PLACES) {
            return -1;
        }
        places[placeCount] = name;
        placeCount++;
        return placeCount - 1;
    }

    public boolean addRoad(String name1, String name2) {
        int a = addPlace(name1);
        int b = addPlace(name2);
        if (a == -1 || b == -1) {
            return false;
        }
        if (a == b) {
            return true;
        }
        adj[a][b] = true;
        adj[b][a] = true; // roads go both ways in an undirected graphg
        return true;
    }

    public void clear() {
        for (int i = 0; i < placeCount; i++) {
            places[i] = null;
            for (int j = 0; j < placeCount; j++) {
                adj[i][j] = false;
            }
        }
        placeCount = 0;
    }

    // Loading the map file
    public boolean loadFromFile(String filename) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (IOException e) {
            return false; // file not found
        }
        clear();
        try {String line;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                line = line.trim();
                if (line.length() == 0) {
                    continue; // skip blank lines
                }
                String[] parts = line.split("\\s+"); // ignore white spaces
                if (parts.length != 2) {
                    System.out.println("Skipping line " + lineNumber + " expected 2 place names: " + line);
                    continue;
                }
                if (!addRoad(parts[0], parts[1])) {
                    System.out.println("Map is full (max " + MAX_PLACES + " places). Stopped reading at line " + lineNumber + ".");
                    break;
                }
            }
            reader.close();
        } catch (IOException e) {
            return false;
        }
        return true;
    }

    public void printGraph() {
        if (placeCount == 0) {
            System.out.println("The map is empty. Load a map file first.");
            return;
        }
        for (int i = 0; i < placeCount; i++) {
            System.out.print(places[i] + " -> ");
            boolean first = true;
            for (int j = 0; j < placeCount; j++) {
                if (adj[i][j]) {
                    if (!first) {
                        System.out.print(", ");
                    }
                    System.out.print(places[j]);
                    first = false;
                }
            }
            System.out.println();
        }
    }
    public void printMatrix() {
        if (placeCount == 0) {
            System.out.println("The map is empty. Load a map file first.");
            return;
        }

        for (int i = 0; i < placeCount; i++) {
            System.out.println(i + " = " + places[i]);
        }
        System.out.println();

        // Header row of column numbers
        System.out.print("    ");
        for (int j = 0; j < placeCount; j++) {
            System.out.printf("%3d", j);
        }
        System.out.println();

        for (int i = 0; i < placeCount; i++) {
            System.out.printf("%3d ", i);
            for (int j = 0; j < placeCount; j++) {
                System.out.printf("%3d", adj[i][j] ? 1 : 0);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Graph g = new Graph();
        g.loadFromFile("src/com/DatstalFinalProjectGroup5E40/resources/map.txt");
        System.out.println("Loaded " + g.getPlaceCount() + " places.\n");
        g.printGraph();
        System.out.println();
        g.printMatrix();
    }
}
