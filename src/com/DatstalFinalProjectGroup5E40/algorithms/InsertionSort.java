package com.DatstalFinalProjectGroup5E40.algorithms;

public class InsertionSort {
    public static void sort(String[] places) {
        if (places == null || places.length <= 1) {
            return;
        }
        for (int x = 1; x < places.length; x++) {
            String current = places[x];
            int y = x - 1;
            while (y >= 0 && places[y] != null && current != null
                    && places[y].compareToIgnoreCase(current) > 0) {
                places[y + 1] = places[y];
                y--;
            }
            places[y + 1] = current;
        }
    }
}