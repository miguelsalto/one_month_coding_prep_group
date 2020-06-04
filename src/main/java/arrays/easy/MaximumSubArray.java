package arrays.easy;

public class MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = 0;
        for (int num : nums) {
            sum = Math.max(num, sum + num);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
