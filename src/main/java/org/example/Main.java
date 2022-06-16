package org.example;

public class Main {
    public static void main(String[] args) {
        int[][] heightMap = {
                {2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2}
        };
        int[][] waterHeightMap = new WaterMap(heightMap).getWaterMap();
        MapViewer.view(waterHeightMap);
    }
}