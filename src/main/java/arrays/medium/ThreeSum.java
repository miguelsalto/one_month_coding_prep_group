package arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int nLen = nums.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nLen; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int first = nums[i];
            int lo = i + 1;
            int hi = nLen - 1;
            while (lo < hi) {
                int sum = first + nums[lo] + nums[hi];
                if (sum == 0) {
                    result.add(Arrays.asList(first, nums[lo], nums[hi]));
                    ++lo;
                    --hi;
                    while (lo < hi && nums[lo] == nums[lo - 1]) {
                        ++lo;
                    }
                    while (lo < hi && nums[hi] == nums[hi + 1]) {
                        --hi;
                    }
                } else if (sum < 0) {
                    ++lo;
                } else {
                    --hi;
                }
            }
        }
        return result;
    }
}
