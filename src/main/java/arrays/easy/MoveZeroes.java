package arrays.easy;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int writeIdx = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) {
                nums[writeIdx++] = nums[i];
            }
        }
        while (writeIdx < nums.length) {
            nums[writeIdx++] = 0;
        }
    }
}
