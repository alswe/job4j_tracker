package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int columns) {
        int rows = (int) Math.ceil((double) list.size() / columns);
        int[][] array = new int[rows][columns];
        int row = 0;
        int column = 0;
        int listIndex = 0;
        for (Integer entry : list) {
            array[row][column] = entry;
            column++;
            if ((listIndex + 1) % columns == 0) {
                column = 0;
                row++;
            }
            listIndex++;
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][] rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }
}