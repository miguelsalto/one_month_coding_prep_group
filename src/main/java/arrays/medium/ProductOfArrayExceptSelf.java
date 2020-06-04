package arrays.medium;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftToRight = new int[n];
        int[] rightToLeft = new int[n];
        int prodLR = 1, prodRL = 1;
        for (int lo = 0, hi = n - 1; lo < n; ++lo, --hi) {
            prodLR *= nums[lo];
            prodRL *= nums[hi];
            leftToRight[lo] = prodLR;
            rightToLeft[hi] = prodRL;
        }
        int[] result = new int[n];
        int lastIdx = n - 1;
        result[0] = rightToLeft[1];
        result[lastIdx] = leftToRight[lastIdx - 1];
        for (int i = 1; i < lastIdx; ++i) {
            result[i] = leftToRight[i - 1] * rightToLeft[i + 1];
        }
        return result;
    }
}
