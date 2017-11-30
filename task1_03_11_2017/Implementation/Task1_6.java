package hw1;

/**
 * 6. Составить программу, которая находит выход из лабиринта из заданной точки.
 *
 * @author Sbitneva Maria
 */
public class Task1_6 {
    private Integer labyrinth[][];
    private int labyrinthMarks[][];
    private int iStart;
    private int jStart;
    private int iExit;
    private int jExit;
    private boolean res = false;
    private int index[][] = {
            {-1, 0},
            {0, 1},
            {1, 0},
            {0, -1}
    };

    Task1_6(Integer labyrinth[][]) {
        this.labyrinth = labyrinth;
        this.labyrinthMarks = new int[labyrinth.length][labyrinth[0].length];
        this.iStart = 0;
        this.jStart = 0;
        this.iExit = labyrinth.length - 1;
        this.jExit = labyrinth[0].length - 1;
    }

    /**
     * Prints current state of labyrinth path
     */
    private void printCurPos(int i, int j) {
        for (int r = 0; r <= iExit; r++) {
            for (int c = 0; c <= jExit; c++) {
                if ((i == r) && (j == c)) {
                    System.out.print("8");
                } else if (labyrinth[r][c] == 1) {
                    System.out.print("*");
                } else if (labyrinth[r][c] == 0) {
                    if (labyrinthMarks[r][c] == 1) {
                        System.out.print("⋅");
                    } else {
                        System.out.print(" ");
                    }
                }
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    /**
     * Recursive DFS through labyrinth
     */
    private boolean dfs(int i, int j) {
        if ((i < 0) || (j > jExit) || (i > iExit) || (j < 0)) {
            return false;
        }

        if ((((i == 0) || (i == iExit)) || ((j == 0) || (j == jExit))) && (labyrinth[i][j] == 0)) {
            if ((i != iStart) && (j != jStart)) {
                labyrinthMarks[i][j] = 1;
                printCurPos(i, j);
                System.out.println("Exit!");
                return true;
            }
        }

        if ((labyrinth[i][j] == 1) || (labyrinthMarks[i][j] == 1)) {
            return false;
        }

        labyrinthMarks[i][j] = 1;
        printCurPos(i, j);
        for (int k = 0; k < 4; k++) {
            res = dfs(i + index[k][0], j + index[k][1]);
            if (res) {
                return true;
            }
        }
        return false;
    }

    /**
     * Finds exit from labyrinth starting from given coordinates i, j
     *
     * @param i starting row
     * @param j starting column
     */
    public void findExitFromLabyrinth(int i, int j) {
        iStart = i;
        jStart = j;

        dfs(iStart, jStart);
    }
}
