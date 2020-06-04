package arrays.easy;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            int num = nums[i];
            Integer idx = seen.get(target - num);
            if (idx != null) {
                return new int[]{idx, i};
            }
            seen.put(num, i);
        }
        return new int[0];
    }
}
