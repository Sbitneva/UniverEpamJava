package sbitneva.homeworks.entities;

import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Forest {

    private static Logger log = Logger.getLogger(Forest.class.getName());
    private int[][] forestMatrix;
    private int nRows;
    private int mColumns;
    private TaskQueue tasks = new TaskQueue();

    public Forest(String filePath) {
        File file = new File(filePath);
        if (file.exists()) {
            try {
                Scanner input = new Scanner(file);
                nRows = input.nextInt();
                mColumns = input.nextInt();
                forestMatrix = new int[nRows][mColumns];
                for (int i = 0; i < nRows; i++) {
                    for (int j = 0; j < mColumns; j++) {
                        forestMatrix[i][j] = input.nextInt();
                    }
                }
                for (int i = 0; i < nRows; i++) {
                    tasks.add(new Task(i, forestMatrix[i]));
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

    @Override
    public String toString() {
        return "Forest{" +
                "forestMatrix=" + Arrays.deepToString(forestMatrix) +
                ", nRows=" + nRows +
                ", mColumns=" + mColumns +
                '}';
    }

    public TaskQueue getTasks() {
        return tasks;
    }
}
