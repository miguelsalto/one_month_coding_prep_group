package arrays.medium;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int r = 0; r < n; r++) {
            swap(matrix, r, 0, r, n - 1, 0);
        }
        for (int c = 0; c < n; c++) {
            swap(matrix, 0, c, n - c - 1, n - 1, 1);
        }
        for (int r = 1; r < n; r++) {
            swap(matrix, r, 0, n - 1, n - r - 1, 1);
        }
    }
    private static void swap(int[][] matrix, int startRow, int startCol, int endRow, int endCol, int deltaRow) {
        while (startCol < endCol) {
            int temp = matrix[startRow][startCol];
            matrix[startRow][startCol] = matrix[endRow][endCol];
            matrix[endRow][endCol] = temp;
            startCol++;
            endCol--;
            startRow += deltaRow;
            endRow -= deltaRow;
        }
    }
}
