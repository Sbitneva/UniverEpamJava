package task1_03_11_2017;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Дана целочисленная прямоугольная матрица.
 * Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
 *
 * @author Sbitneva Maria
 */

public class Task1_4 {
    private static Integer[][] swapRows(Integer matrix[][], Integer maxSeqLen[][]){

        Integer newMatrix[][] = new Integer[matrix.length][matrix[0].length];

        for(int i = 0; i < matrix.length; i++){
            int index = maxSeqLen[i][1];
            //System.out.println(index);
            for(int j = 0; j < matrix[0].length; j++){
                newMatrix[i][j] = matrix[index][j];
            }
        }
        return newMatrix;
    }

    /**
     * Sorts matrix columns by value of first element of column
     *
     * @param maxSeqLen matrix where the first column contains lenghts
     * of max sequences and the second column contains source indexes
     * of matrix rows
     */
    private static void sortLenMatrix(Integer maxSeqLen[][]){
        Arrays.sort(maxSeqLen, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] a, Integer[] b) {

                return Integer.compare(a[0], b[0]);
            }
        });
    }

    /**
     * Finds max length of sequence of identical numbers in array
     * @param sequence array of integer values
     * @return max length of sequence
     */
    private static Integer findMaxSeqLen(Integer sequence[]){
        int maxLen = 0;
        int curLen = 1;
        Integer value = sequence[0];

        for(int i = 1; i < sequence.length; i++){
            if(sequence[i].equals(value)){
                curLen++;
            }else{
                if(maxLen < curLen){
                    maxLen = curLen;
                }
                curLen = 1;
                value = sequence[i];
            }
        }
        return maxLen;
    }

    /**
     * Sorts matrix rows in ascending order by the longest series of the same elements.
     *
     * @param matrix rectangular matrix of integers
     * @return sorted matrix
     */
    public static Integer[][] sort(Integer matrix[][]){
        Integer maxSeqLen[][] = new Integer[matrix.length][2];

        for(int i = 0; i < matrix.length; i++){
            maxSeqLen[i][0] = findMaxSeqLen(matrix[i]);
            maxSeqLen[i][1] = i;
        }

        sortLenMatrix(maxSeqLen);

        return swapRows(matrix, maxSeqLen);
    }
}
