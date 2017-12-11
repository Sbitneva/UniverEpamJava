package sbitneva.homeworks.entities;

import java.util.ArrayList;

public class Task {
    private int taskIndex;
    private int taskData[][];
    private int rows;
    private int columns;
    private ArrayList<Integer> rowIndexes;

    public Task(int startIndex, int sliceSize, int matrix[][]){
        int size = 0;
        rowIndexes = new ArrayList<>();
        if((startIndex + sliceSize) < matrix.length){
            size = sliceSize;
        }else{
            size = matrix.length - startIndex;
        }
        int endIndex = startIndex + size;
        int start = 0;
        taskData = new int[size][matrix[0].length];
        this.rows = size;
        this.columns = matrix[0].length;

        for(int i = startIndex; i < endIndex; i++){
            taskData[start] = matrix[i];
            rowIndexes.add(i);
            start++;
        }
    }

    public ArrayList<Integer> getRowIndexes() {
        return rowIndexes;
    }

    public int getTaskIndex() {
        return taskIndex;
    }

    public int[][] getTaskData() {
        return taskData;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }
}
