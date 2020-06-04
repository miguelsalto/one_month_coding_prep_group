package arrays.easy;

public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int idx = 1;
        int pLen = prices.length;
        while (idx < pLen) {
            int diff = prices[idx] - prices[idx - 1];
            if (diff > 0) {
                max += diff;
            }
            ++idx;
        }
        return max;
    }
}
