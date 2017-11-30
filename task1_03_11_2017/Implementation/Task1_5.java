package hw1;
/**
 *  5. Дана квадратная матрица A порядка M (M — нечетное число). Начи-
 * ная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее эле-
 * менты по спирали: первая строка, последний столбец, последняя строка в
 * обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  эле-
 * менты второй строки и т. д.; последним выводится центральный элемент
 * матрицы.
 *
 * @author Sbitneva Maria *
 */
public class Task1_5 {

    /**
     * Prints matrix elements spirally from A1,1 element.
     *
     * @param matrix square matrix with odd order
     */
    public static void printClockwise(Integer matrix[][]) {
        int stepsAmount = matrix[0].length * matrix[0].length;
        int curStep = 0;
        int iStart = 0;
        int jStart = 0;
        int iEnd = matrix.length - 1;
        int jEnd = matrix.length - 1;

        while (curStep < stepsAmount) {
            for (int j = jStart; j <= jEnd; j++) {
                System.out.print(matrix[iStart][j] + "\t");
                curStep++;
            }
            System.out.println();
            for (int i = iStart + 1; i <= iEnd; i++) {
                System.out.print(matrix[i][jEnd] + "\t");
                curStep++;
            }
            System.out.println();
            for (int j = jEnd - 1; j >= jStart; j--) {
                System.out.print(matrix[iEnd][j] + "\t");
                curStep++;
            }
            System.out.println();
            for (int i = iEnd - 1; i >= iStart + 1; i--) {
                System.out.print(matrix[i][jStart] + "\t");
                curStep++;
            }
            System.out.println();

            iStart++;
            iEnd--;
            jStart++;
            jEnd--;

        }
    }
}
