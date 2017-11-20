package task1_03_11_2017;

/**
 * 2. В одномерном массиве сначала положительные потом отрицательные за О(n).
 *
 * @author Sbitneva Maria *
 */
public class Task1_2 {
    /**
     * Groups array with O(n) time complexity: at first - positive and then - negative
     *
     * @param sequence of integers for sorting
     */
    public static void groupPosFirst(Integer sequence[]) {
        int start = 0;
        int end = sequence.length - 1;

        while (start < end) {
            if (sequence[start] < 0) {
                while (sequence[end] < 0) {
                    end--;
                }
                if (start < end) {
                    int temp = sequence[start];
                    sequence[start] = sequence[end];
                    sequence[end] = temp;
                }
            }
            start++;
        }
    }
}
