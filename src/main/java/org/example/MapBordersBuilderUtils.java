package org.example;

public class MapBordersBuilderUtils {
    public static int[][] buildMapBorders(int lines, int columns) {
        int[][] mapBorders = new int[lines][columns];
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                mapBorders[i][j] = -1;
                mapBorders[0][j] = 0;
                mapBorders[i][0] = 0;
                mapBorders[i][columns - 1] = 0;
                mapBorders[lines - 1][j] = 0;
            }
        }
        return mapBorders;
    }
}
