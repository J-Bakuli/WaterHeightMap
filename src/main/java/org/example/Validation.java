package org.example;

public class Validation {
    public static void checkNullCells(int[][] map) {
        if (map == null) {
            throw new IllegalArgumentException("Map can't be empty");
        }
    }
}
