package arrays.medium;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        int idx = n - 2;
        while (idx >= 0 && nums[idx] >= nums[idx + 1]) {
            --idx;
        }
        if (idx < 0) {
            reverse(nums, 0, n - 1);
            return;
        }
        int toSwap = nums[idx];
        int minIdx = idx + 1;
        for (int i = minIdx + 1; i < n; ++i) {
            int val = nums[i];
            if (val > toSwap && val <= nums[minIdx]) {
                minIdx = i;
            }
        }
        swap(nums, idx, minIdx);
        reverse(nums, idx + 1, n - 1);
    }

    private static void reverse(int[] nums, int lo, int hi) {
        while (lo < hi) {
            swap(nums, lo++, hi--);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
