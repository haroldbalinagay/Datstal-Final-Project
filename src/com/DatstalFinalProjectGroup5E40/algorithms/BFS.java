package com.DatstalFinalProjectGroup5E40.algorithms;
import com.DatstalFinalProjectGroup5E40.datastructure.Graph;
import com.DatstalFinalProjectGroup5E40.datastructure.Queue;

public class BFS {
    public static void findPath(Graph graph, String startName, String endName) {
        int n = graph.getPlaceCount();

        if (n == 0) {
            IO.println("The map is empty. Load a map file first.");
            return;
        }
        //find indices using graph's built-in findPlace method
        int startIndex = graph.findPlace(startName);
        int endIndex = graph.findPlace(endName);
        //check if place names are valid
        if (startIndex == -1 || endIndex == -1) {
            IO.println("Error: Place name is wrong. Please check your spelling.");
            return;
        }
        //check if start and end are the same
        if (startIndex == endIndex) {
            IO.println("You are already at " + graph.getPlaceName(startIndex) + ". Stops: 0");
            return;
        }
        //bfs tracking Structures
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
        Queue queue = new Queue(n);
        //start bfs from startIndex
        visited[startIndex] = true;
        queue.enqueue(startIndex);
        boolean pathFound = false;
        while (!queue.isEmpty()) {
            int current = queue.dequeue();
            //if destination is reached
            if (current == endIndex) {
                pathFound = true;
                break;
            }
            //explore neighbors using graph's isConnected method
            for (int neighbor = 0; neighbor < n; neighbor++) {
                if (graph.isConnected(current, neighbor) && !visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                    queue.enqueue(neighbor);
                }
            }
        }
        //check if path exists
        if (!pathFound) {
            IO.println("Error: There is no path between " + startName + " and " + endName + ".");
            return;
        }
        //reconstruct path from destination back to start using parent array
        int[] tempPath = new int[n];
        int pathLength = 0;
        int curr = endIndex;
        while (curr != -1) {
            tempPath[pathLength++] = curr;
            curr = parent[curr];
        }
        //reverse the path to go from start to end and print the results
        IO.println("\nPath Found:");
        IO.print("Path: ");
        for (int i = pathLength - 1; i >= 0; i--) {
            IO.print(graph.getPlaceName(tempPath[i]));
            if (i > 0) {
                IO.print(" -> ");
            }
        }
        //number of stops = edges traversed (pathLength - 1)
        int stops = pathLength - 1;
        IO.println("\nNumber of stops: " + stops);
    }
}