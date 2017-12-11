package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Forest {

    private static Logger log = Logger.getLogger(Forest.class.getName());
    private int [][] forestMatrix;
    private int nRows;
    private int mColumns;
    private int sliceSize;
    private Queue<Task> tasks = new LinkedList<>();


    public Forest(String filePath, int tasksNumber){
        File file = new File(filePath);
        if(file.exists()) {
            try {
                Scanner input = new Scanner(file);
                nRows = input.nextInt();
                mColumns = input.nextInt();
                forestMatrix = new int [nRows][mColumns];
                for(int i = 0; i < nRows; i++){
                    for(int j = 0; j < mColumns; j++){
                        forestMatrix[i][j] = input.nextInt();
                    }
                }
                this.sliceSize = nRows/tasksNumber;

                int i = 0;
                while(i < forestMatrix.length){
                    tasks.add(new Task(i, sliceSize, forestMatrix));
                    i = i + sliceSize;
                }
            } catch (FileNotFoundException e) {
                log.error(e.getMessage());
            }
        }
    }

    public int getnRows() {
        return nRows;
    }

    public int getmColumns() {
        return mColumns;
    }

    public int[][] getForestMatrix() {
        return forestMatrix;
    }

    public int getSliceSize() {
        return sliceSize;
    }

    @Override
    public String toString() {
        return "Forest{" +
                "forestMatrix=" + Arrays.deepToString(forestMatrix) +
                ", nRows=" + nRows +
                ", mColumns=" + mColumns +
                '}';
    }

    public Queue<Task> getTasks() {
        return tasks;
    }
}
