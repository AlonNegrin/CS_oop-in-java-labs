import java.util.Arrays;

public class Table {
    private int[][] board = null;
    private int height;
    private int width;

    /**
     * Constructor
     *
     * @param height - height of table
     * @param width  - width of table
     */

    public Table(int width, int height) {
        board = new int[width + 1][height + 1];
        for (int i = 1; i <= width; i++) {
            for (int j = 1; j <= height; j++) {
                board[i][j] = i * j;
            }
        }

    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int[][] getBoard() {
        return board;
    }

    public int getHeight() {
        return height;
    }

    public void displayAll() {
        for (int i = 1; i <= this.width; i++) {
            System.out.println();
            for (int j = 1; j <= this.height; j++) {
                System.out.print("[" + i + "]:" + "[" + j + "] = " + i * j);
            }
        }
    }

    void display(int width, int height) {
        display(1, width, 1, height);
    }

    /**
     * display any contiguous part of the table
     *
     * @param fc - from column
     * @param tc - to column
     * @param fr - from row
     * @param tr - to row
     */
    void display(int fc, int tc, int fr, int tr) {
        System.out.format("Multiplication Table ([%d..%d]x[%d..%d])\n", fc, tc, fr, tr);
        System.out.println();
        System.out.print("       ");
        for (int i = fc; i <= tc; i++) {
            System.out.printf("%6d ", i);
        }
        System.out.println();
        for (int j = fr; j <= tr; j++) {
            System.out.format("%6d ", j);
            for (int i = fc; i <= tc; i++) {
                System.out.printf("%6d ", board[j][i]);
            }
            System.out.println();
        }
    }
}




