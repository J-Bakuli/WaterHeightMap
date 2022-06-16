package org.example;

public class MapViewer {
    public static void view(int[][] array) {
        for (int[] x : array) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }
}
