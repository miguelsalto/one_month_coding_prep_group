package arrays.easy;

public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            profit = Math.max(profit, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return profit;
    }
}
