package arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpiralMatrix {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return Collections.emptyList();
        }
        int rows = matrix.length, cols = matrix[0].length;
        int total = rows * cols;
        List<Integer> result = new ArrayList<>();
        int left = 0, right = cols - 1, up = 0, down = rows - 1, dir = 0;
        int row = 0, col = -1;
        for (int i = 0; i < total; ++i) {
            int nextRow = row + DIRECTIONS[dir][0];
            int nextCol = col + DIRECTIONS[dir][1];
            if (nextRow >= up && nextRow <= down && nextCol >= left && nextCol <= right) {
                result.add(matrix[nextRow][nextCol]);
                row = nextRow;
                col = nextCol;
            } else {
                dir = (dir + 1) % 4;
                if (dir == 0) ++left;
                else if (dir == 1) ++up;
                else if (dir == 2) --right;
                else --down;
                --i;
            }
        }
        return result;
    }
}
