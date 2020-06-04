package arrays.medium;

public class SortColors {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int lo = 0, mid = 0, hi = n - 1;
        while (mid <= hi) {
            int val = nums[mid];
            if (val == 0) {
                swap(nums, lo++, mid++);
            } else if (val == 2) {
                swap(nums, mid, hi--);
            } else {
                ++mid;
            }
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
