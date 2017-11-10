package task1;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Дана целочисленная прямоугольная матрица.
 * 3. Упорядочить столбцы по убыванию среднего значения.
 *
 * @author Sbitneva Maria
 */
public class Task1_3 {
    /**
     * Creates a matrix colAver[n][2],
     * where colAver[i][0] contain an average of matrix column elements
     * colAver[i][1] contain an index of matrix column
     *
     * @param matrix 2d array
     * @return an matrix with averages of columns averages of input matrix
     */
    private static Float[][] columnAverage(Integer matrix[][]) {
        Float colAver[][] = new Float[matrix[0].length][2];

        for (int i = 0; i < matrix[0].length; i++) {
            Float sum = 0f;

            for (int j = 0; j < matrix.length; j++) {
                sum += (float) matrix[j][i];
            }
            colAver[i][0] = sum / (float) matrix.length;
            colAver[i][1] = (float) i;
        }
        return colAver;
    }

    /**
     * Swaps columns in matrix
     *
     * @param matrix source matrix for swapping
     * @param colAver matrix with sorted indexes of source matrix
     */
    private static Integer[][] swapColumns(Integer matrix[][], Float colAver[][]) {
        Integer newMatrix[][] = new Integer[matrix.length][matrix[0].length];

        for (int i = 0; i < colAver.length; i++) {
            int index = Integer.valueOf(Math.round(colAver[i][1]));
            for (int j = 0; j < matrix.length; j++) {
                newMatrix[j][i] = matrix[j][index];
            }
        }
        return newMatrix;
    }

    /**
     * Sorts matrix columns in descending order by average values of columns
     *
     * @param matrix rectangular matrix of integers
     * @return sorted matrix
     */
    public static Integer[][] sort(Integer matrix[][]) {
        Float colAver[][] = columnAverage(matrix);

        Arrays.sort(colAver, new Comparator<Float[]>() {
            @Override
            public int compare(Float[] column1, Float[] column2) {

                return Float.compare(column2[0], column1[0]);
            }
        });
        return swapColumns(matrix, colAver);
    }
}
