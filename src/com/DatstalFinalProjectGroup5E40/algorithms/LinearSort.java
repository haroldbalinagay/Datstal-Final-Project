package com.DatstalFinalProjectGroup5E40.algorithms;

public class LinearSort {

    public static int search(String[] places, String target) {

        for (int x = 0; x < places.length; x++) {

            if (places[x].equalsIgnoreCase(target)) {
                return x;
            }
        }

        return -1;
    }
}
