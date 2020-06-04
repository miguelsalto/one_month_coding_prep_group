package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        if (n == 0) {
            return new int[0][0];
        }
        Arrays.sort(intervals, (x, y) -> {
            int val = Integer.compare(x[0], y[0]);
            return val == 0 ? Integer.compare(x[1], y[1]) : val;
        });
        List<int[]> merged = new ArrayList<>();
        int[] last = intervals[0];
        merged.add(last);
        for (int i = 1; i < n; ++i) {
            int[] current = intervals[i];
            if (current[0] <= last[1]) {
                last[1] = Math.max(last[1], current[1]);
            } else {
                last = current;
                merged.add(last);
            }
        }
        int size = merged.size();
        int[][] result = new int[size][];
        for (int i = 0; i < size; ++i) {
            result[i] = merged.get(i);
        }
        return result;
    }
}
