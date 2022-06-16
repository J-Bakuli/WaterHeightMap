package org.example;

public class MinWaterLevelUtils {
    public static int getMinWaterLevel(int i, int j, int[][] locationMap, int[][] waterMap, boolean[][] underWater) {
        if (locationMap[i][j] == 0) {
            waterMap[i][j] = 0;
            return 0;
        }
        if (waterMap[i][j] != -1) {
            return waterMap[i][j];
        }
        if (underWater[i][j]) {
            return Integer.MAX_VALUE;
        }
        underWater[i][j] = true;
        int min = Integer.MAX_VALUE;
        int waterLevel;
        int moveValue;

        int move = j + 1;

        if (waterMap[i][move] != -1) {
            waterLevel = waterMap[i][move];
        } else {
            waterLevel = getMinWaterLevel(i, move, locationMap, waterMap, underWater);
        }
        moveValue = Math.max(waterLevel, locationMap[i][move]);
        if (moveValue <= locationMap[i][j]) {
            waterMap[i][j] = 0;
            underWater[i][j] = false;
            return 0;
        }
        if (moveValue < min) {
            min = moveValue;
        }

        move = i - 1;

        if (waterMap[move][j] != -1) {
            waterLevel = waterMap[move][j];
        } else {
            waterLevel = getMinWaterLevel(move, j, locationMap, waterMap, underWater);
        }
        moveValue = Math.max(waterLevel, locationMap[move][j]);
        if (moveValue <= locationMap[i][j]) {
            waterMap[i][j] = 0;
            underWater[i][j] = false;
            return 0;
        }
        if (moveValue < min) {
            min = moveValue;
        }

        move = j - 1;

        if (waterMap[i][move] != -1) {
            waterLevel = waterMap[i][move];
        } else {
            waterLevel = getMinWaterLevel(i, move, locationMap, waterMap, underWater);
        }
        moveValue = Math.max(waterLevel, locationMap[i][move]);
        if (moveValue <= locationMap[i][j]) {
            waterMap[i][j] = 0;
            underWater[i][j] = false;
            return 0;
        }
        if (moveValue < min) {
            min = moveValue;
        }

        move = i + 1;

        if (waterMap[move][j] != -1) {
            waterLevel = waterMap[move][j];
        } else {
            waterLevel = getMinWaterLevel(move, j, locationMap, waterMap, underWater);
        }
        moveValue = Math.max(waterLevel, locationMap[move][j]);
        if (moveValue <= locationMap[i][j]) {
            waterMap[i][j] = 0;
            underWater[i][j] = false;
            return 0;
        }
        if (moveValue < min) {
            min = moveValue;
        }

        underWater[i][j] = false;
        return min;
    }
}
