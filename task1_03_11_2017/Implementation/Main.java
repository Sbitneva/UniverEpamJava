package hw1;

import hw1.utils.*;
import java.util.Arrays;

/**
 * Домашнее задание 2
 *
 * Сортировка последовательности
 * 1. Упорядочить одномерный масиве вначале отрицательные по возрастанию
 * затем положительные по убыванию.
 * 2. В одномерном массиве сначала положительные потом отрицательные за О(n).
 *
 * Дана целочисленная прямоугольная матрица.
 * 3. Упорядочить столбцы по убыванию среднего значения.
 * 4. Упорядочить строки, по возрастанию по самой длинной серии одинаковых элементов.
 *
 * 5. Дана квадратная матрица A порядка M (M — нечетное число). Начи-
 * ная с элемента A1,1 и перемещаясь по часовой стрелке, вывести все ее эле-
 * менты по спирали: первая строка, последний столбец, последняя строка в
 * обратном  порядке,  первый  столбец  в  обратном  порядке,  оставшиеся  эле-
 * менты второй строки и т. д.; последним выводится центральный элемент
 * матрицы.
 *
 * 6. Составить программу, которая находит выход из лабиринта из заданной точки.
 *
 * @author Sbitneva Maria
 */

public class Main {

    public static void main(String... args) {

        Integer task1[] = {1, -2, 3, -11, 12, -8, 6, -2, 3, -4, -5, 7, 2};
        Integer task2[] = {-1, 2, -3, 4, -5, 1, -2, 3, -4, -5, 6};


        Integer task3[][] = {{1, 2, 30},
                {5, 8, 0},
                {8, 7, 4},
                {11, 0, 0}};

        Integer task4[][] = {{1, 2, 2, 2, 3},
                {5, 5, 5, 5, 0},
                {8, 8, 7, 4, 4}};

        Integer task5[][] = {{1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};

        Integer labyrinth[][] = {
                {0, 1, 1, 1, 1, 0, 1, 1, 1, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 1, 1, 0, 1, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1, 1, 1, 0, 0}
        };

        System.out.println("task 2.1");
        System.out.println("Input array:");
        System.out.println(Arrays.toString(task1));
        Task1_1.sortGroup(task1);
        System.out.println("Output array:");
        System.out.println(Arrays.toString(task1));
        System.out.println("=======================================");

        System.out.println("\ntask 2.2");
        System.out.println("Input array:");
        System.out.println(Arrays.toString(task2));
        System.out.println("Output array:");
        Task1_2.groupPosFirst(task2);
        System.out.println(Arrays.toString(task2));
        System.out.println("=======================================");

        System.out.println("\ntask 2.3");
        System.out.println("Input matrix:");
        PrintData.printMatrix(task3);
        System.out.println("Output matrix:");
        PrintData.printMatrix(Task1_3.sort(task3));
        System.out.println("=======================================");

        System.out.println("\ntask 2.4");
        System.out.println("Input matrix:");
        PrintData.printMatrix(task4);
        System.out.println("Output matrix:");
        PrintData.printMatrix(Task1_4.sort(task4));
        System.out.println("=======================================");

        System.out.println("\ntask 2.5");
        System.out.println("Input matrix:");
        PrintData.printMatrix(task5);
        System.out.println("Output matrix:");
        Task1_5.printClockwise(task5);

        System.out.println("\ntask 2.6\n");
        Task1_6 task6 = new Task1_6(labyrinth);
        task6.findExitFromLabyrinth(0, 5);

    }
}
