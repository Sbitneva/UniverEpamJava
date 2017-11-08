package utils;
public class PrintData {
    /**
     * Prints matrix by rows
     */
    public static void printMatrix(Integer matrix[][]) {

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }


}
