package task0;
/**
 * Домашнее задание 1
 *
 * Используя циклы и метод:
 * System.out.print("* "), System.out.print("  "),
 * System.out.print("\n")
 * (для перехода на новую строку).
 * Выведите на экран:
 * · прямоугольник
 * · прямоугольный треугольник
 * · равносторонний треугольник
 * · ромб
 *
 * @author Sbitneva Maria
 */

public class FiguresDrawing {

    public static void main(String... args) {

        //rectangle
        {
            int a = 10;
            int b = 12;

            for (int i = 0; i < a; i++) {
                for (int j = 0; j < b; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }

        //right triangle
        {
            int a = 10;

            for (int i = 0; i < a; i++) {
                for (int j = 0; j <= i; j++) {
                    System.out.print("*");
                }
                System.out.print("\n");
            }
            System.out.print("\n");
        }

        //equilateral triangle
        {
            int h = 10;
            int i = 1;
            int j = h - i;

            for (int k = 0; k < h; k++) {
                for (int m = 0; m < j; m++) {
                    System.out.print(" ");
                }
                for (int m = 0; m < i; m++) {
                    System.out.print("*");
                }
                j--;
                i = i + 2;
                System.out.print("\n");
            }
            System.out.print("\n");
        }
        //rhombus
        {
            int h = 7;
            int i = 1;
            int j = h;

            for (int k = 0; k < h; k++) {
                for (int m = 0; m < j; m++) {
                    System.out.print(" ");
                }
                for (int m = 0; m < i; m++) {
                    System.out.print("*");
                }
                j--;
                i = i + 2;
                System.out.print("\n");
            }
            for (int k = 0; k <= h; k++) {
                for (int m = 0; m < j; m++) {
                    System.out.print(" ");
                }
                for (int m = 0; m < i; m++) {
                    System.out.print("*");
                }
                j++;
                i = i - 2;
                System.out.print("\n");
            }
            System.out.print("\n");
        }
    }

}
