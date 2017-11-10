package task1;
import java.util.Arrays;
import java.util.Collections;
/**
 * 1. Упорядочить одномерный масиве вначале отрицательные по возрастанию
 *
 * @author Sbitneva Maria
 */

public class Task1_1 {

    /**
     * Returns an array of integers where negative numbers sorted in descending order and
     * positive numbers sorted in ascending order
     *
     * @param sequence array of integers for sorting
     */
    public static void sortGroup(Integer sequence[]) {
        int posStart = groupNegFirst(sequence);

        Arrays.sort(sequence, 0, posStart, Collections.reverseOrder());
        Arrays.sort(sequence, posStart, sequence.length);
    }

    /**
     * Groups array with O(n) time complexity: at first - negative and then - positive
     *
     * @param sequence for sorting
     */
    private static Integer groupNegFirst(Integer sequence[]) {
        int start = 0;
        int end = sequence.length - 1;

        while (start < end) {
            if (sequence[start] > 0) {
                while (sequence[end] > 0) {
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
        return --start;
    }

}
