package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WaterHeightMapTest {

    @Test
    void waterHeightMapBuilder_toReturnZeros_forEqualHeights() {
        int[][] landscapeMap = {
                {2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2}
        };
        WaterMap builder = new WaterMap(landscapeMap);
        int[][] expected = {
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}
        };
        int[][] actual = builder.getWaterMap();
        assertArrayEquals(expected, actual);
    }

    @Test
    void waterHeightMapBuilder_toReturnValues_whenCellsAreSurroundedByHigherValues() {
        int[][] landscapeMap = {
                { 1, 3, 4, 5},
                { 4, 1, 1, 4},
                { 5, 6, 7, 2}
        };
        WaterMap builder = new WaterMap(landscapeMap);
        int[][] expected =  {
                { 0, 0, 0, 0},
                { 0, 3, 3, 0},
                { 0, 0, 0, 0}
        };
        int[][] actual = builder.getWaterMap();
        assertArrayEquals(expected, actual);
    }

    @Test
    void waterHeightMapBuilder_toReturnZeros_whenInnerCellIsZero() {
        int[][] landscapeMap = {
                { 1, 3, 4, 5},
                { 4, 1, 0, 4},
                { 5, 6, 7, 2}
        };
        WaterMap builder = new WaterMap(landscapeMap);
        int[][] expected =  {
                { 0, 0, 0, 0},
                { 0, 0, 0, 0},
                { 0, 0, 0, 0}
        };
        int[][] actual = builder.getWaterMap();
        assertArrayEquals(expected, actual);
    }

    @Test
    void waterHeightMapBuilder_toReturnTwoZones_whenSurroundedByHigherValues() {
        int[][] landscapeMap = {
                { 1, 2, 1, 4, 4, 1},
                { 2, 1, 4, 1, 1, 4},
                { 2, 1, 3, 1, 1, 4},
                { 1, 2, 1, 4, 4, 1},
                { 1, 1, 1, 1, 1, 1}
        };
        WaterMap builder = new WaterMap(landscapeMap);
        int[][] expected =  {
                { 0, 0, 0, 0, 0, 0},
                { 0, 2, 0, 3, 3, 0},
                { 0, 2, 0, 3, 3, 0},
                { 0, 0, 0, 0, 0, 0},
                { 0, 0, 0, 0, 0, 0}
        };
        int[][] actual = builder.getWaterMap();
        assertArrayEquals(expected, actual);
    }

    @Test
    void waterHeightMapBuilder_toThrowIllegalArgumentException_forEmptyData() {
        assertThrows(IllegalArgumentException.class, () -> new WaterMap(null));
    }
}