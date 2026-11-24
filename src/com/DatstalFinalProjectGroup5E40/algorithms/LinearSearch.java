package com.DatstalFinalProjectGroup5E40.algorithms;

public class LinearSearch {
    public static int search(String[] places, String target) {
        if (places == null || target == null) {
            return -1;
        }
        String cleanedTarget = target.trim();
        for (int x = 0; x < places.length; x++) {
            if (places[x] != null && places[x].equalsIgnoreCase(cleanedTarget)) {
                return x;
            }
        }
        return -1;
    }
}