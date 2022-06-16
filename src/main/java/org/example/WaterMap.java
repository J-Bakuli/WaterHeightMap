package org.example;

public class WaterMap {
    private final int[][] locationMap;
    private int[][] waterMap;
    private boolean[][] underWater;

    public WaterMap(int[][] heightMap) {
        Validation.checkNullCells(heightMap);
        this.locationMap = heightMap;
    }

    public int[][] getWaterMap() {
        int lines = locationMap.length;
        int columns = locationMap[0].length;
        waterMap = new int[lines][columns];
        underWater = new boolean[lines][columns];
        waterMap = MapBordersBuilderUtils.buildMapBorders(lines, columns);
        for (int i = 1; i < lines; i++) {
            for (int j = 1; j < columns; j++) {
                waterMap[i][j] = MinWaterLevelUtils.getMinWaterLevel(i, j, locationMap, waterMap, underWater);
            }
        }
        return waterMap;
    }
}